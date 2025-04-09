package org.yyzx.mysql.innodb.handler.page;

public class PageId {

    private final int spaceNo;

    private final int pageNo;

    public PageId(int spaceNo, int pageNo) {
        this.spaceNo = spaceNo;
        this.pageNo = pageNo;
    }

    public int getSpaceNo() {
        return spaceNo;
    }

    public int getPageNo() {
        return pageNo;
    }
}
