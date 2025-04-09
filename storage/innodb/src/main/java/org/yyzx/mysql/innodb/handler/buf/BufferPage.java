package org.yyzx.mysql.innodb.handler.buf;

import org.yyzx.mysql.innodb.handler.page.PageId;

import java.nio.ByteBuffer;

public class BufferPage {

    private final PageId pageId;

    /**
     * 页面数据
     */
    private final ByteBuffer frame;

    public BufferPage(PageId pageId, ByteBuffer frame) {
        this.pageId = pageId;
        this.frame = frame;
    }

    public ByteBuffer getFrame() {
        return frame;
    }

    public PageId getPageId() {
        return pageId;
    }
}
