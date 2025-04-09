package org.yyzx.mysql.innodb.handler.buf;

import org.yyzx.mysql.innodb.handler.file.FileSystem;
import org.yyzx.mysql.innodb.handler.page.PageId;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BufSystem {

    public final static BufSystem INSTANCE = new BufSystem();

    public final static Map<PageId, BufferPage> ID_MAP = new ConcurrentHashMap<>();

    public BufferPage getBuf(PageId pageId) {
        BufferPage bufferPage = ID_MAP.get(pageId);
        if (null == bufferPage) {
            bufferPage = FileSystem.INSTANCE.findPage(pageId);
            ID_MAP.put(pageId, bufferPage);
        }
        return bufferPage;
    }
}
