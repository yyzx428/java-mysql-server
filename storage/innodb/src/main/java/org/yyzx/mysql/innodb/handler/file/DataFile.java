package org.yyzx.mysql.innodb.handler.file;

public class DataFile {

    private final String filePath;

    private final int size;

    private final int flags;

    private final int order;

    public DataFile(String filePath, int size, int flags, int order) {
        this.filePath = filePath;
        this.size = size;
        this.flags = flags;
        this.order = order;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getSize() {
        return size;
    }

    public int getFlags() {
        return flags;
    }

    public int getOrder() {
        return order;
    }
}
