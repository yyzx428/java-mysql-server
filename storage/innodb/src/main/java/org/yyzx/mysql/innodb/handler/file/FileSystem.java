package org.yyzx.mysql.innodb.handler.file;

import org.yyzx.mysql.innodb.handler.buf.BufferPage;
import org.yyzx.mysql.innodb.handler.common.InnodbConstants;
import org.yyzx.mysql.innodb.handler.page.FspHeaderPage;
import org.yyzx.mysql.innodb.handler.page.PageId;
import org.yyzx.mysql.innodb.handler.table.Tablespace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class FileSystem {

    public static final FileSystem INSTANCE = new FileSystem();

    private Map<Integer, FileTablespace> SPACE_MAP = new HashMap<>();

    public static void createTableSpace(Tablespace tablespace) {
        //获取spaceNo
        tablespace.setSpaceNo(0);

        DataFile dataFile = tablespace.getFirstDataFile();
        if (exitsFile(dataFile.getFilePath())) {
            throw new RuntimeException();
        }

        createFile(tablespace);

        fillFspHeader(tablespace.getFirstDataFile());
    }

    private static void fillFspHeader(DataFile firstDataFile) {
        File file = new File(firstDataFile.getFilePath());

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(InnodbConstants.PAGE_SIZE);
            new FspHeaderPage().write(byteBuffer);

            fileOutputStream.write(byteBuffer.array());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void createFile(Tablespace tablespace) {
        String filePath = tablespace.getFirstDataFile().getFilePath();
        File file = new File(filePath);
        try {
            Files.createDirectories(file.toPath());
            Files.createFile(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean exitsFile(String filePath) {
        return new File(filePath).exists();
    }

    public BufferPage findPage(PageId pageId) {
        FileTablespace fileTablespace = SPACE_MAP.get(pageId.getSpaceNo());

        int pageNo = pageId.getPageNo();
        FileNode fileNode = fileTablespace.findPageNo(pageNo);

        int offset = (pageNo - fileNode.getStartPage()) * 16 * 1024;

        ByteBuffer byteBuffer = ByteBuffer.allocate(16 * 1024);
        try {
            fileNode.getFd().read(byteBuffer, offset);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return new BufferPage(pageId, byteBuffer);
    }
}
