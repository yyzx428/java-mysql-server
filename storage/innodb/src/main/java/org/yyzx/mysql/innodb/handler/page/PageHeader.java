package org.yyzx.mysql.innodb.handler.page;

public class PageHeader {
    private final int spaceNo;

    private final int pageNo;

    private int prevPageNo;

    private int nextPageNo;

    private long lsn;

    private short pageType;

    private long flushLsn;

    private int flags;

    public PageHeader(int spaceNo, int pageNo) {
        this.spaceNo = spaceNo;
        this.pageNo = pageNo;
    }

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
}
