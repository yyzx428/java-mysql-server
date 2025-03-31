package org.yyzx.mysql.innodb.handler.page;

public class FspHeaderPage extends Page {
    /**
     * 表空间大小，以Page数量计算
     */
    private int size;

    /**
     * 目前在空闲的Extent上最小的尚未被初始化的Page的`Page Number
     */
    private int freeLimit;

    private TList free;

    private TList freeFrag;

    private TList segInodesFull;

    private TList segInodesFree;

    public FspHeaderPage(PageHeader header) {
        super(header);
    }
}
