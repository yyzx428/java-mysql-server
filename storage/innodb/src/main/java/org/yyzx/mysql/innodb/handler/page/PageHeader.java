package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

public class PageHeader implements SerializablePage {

    private int spaceNo;

    private int pageNo;

    private int prevPageNo;

    private int nextPageNo;

    private long lsn;

    private short pageType;

    private long flushLsn;

    private int flags;

    public int getSpaceNo() {
        return spaceNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getPrevPageNo() {
        return prevPageNo;
    }

    public void setPrevPageNo(int prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    public int getNextPageNo() {
        return nextPageNo;
    }

    public void setNextPageNo(int nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    public long getLsn() {
        return lsn;
    }

    public void setLsn(long lsn) {
        this.lsn = lsn;
    }

    public short getPageType() {
        return pageType;
    }

    public void setPageType(short pageType) {
        this.pageType = pageType;
    }

    public long getFlushLsn() {
        return flushLsn;
    }

    public void setFlushLsn(long flushLsn) {
        this.flushLsn = flushLsn;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(short flags) {
        this.flags = flags;
    }

    @Override
    public int write(ByteBuffer stream) {
        return 0;
    }

    @Override
    public int read(ByteBuffer stream) {
        return 0;
    }
}
