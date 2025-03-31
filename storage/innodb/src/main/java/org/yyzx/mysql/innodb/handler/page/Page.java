package org.yyzx.mysql.innodb.handler.page;

public abstract class Page {

    private final PageHeader header;

    public Page(PageHeader header) {
        this.header = header;
    }

    public PageHeader getHeader() {
        return header;
    }
}
