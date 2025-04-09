package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

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

    private TList fullFrag;

    private long segId;

    private TList segInodesFull;

    private TList segInodesFree;

    private XdesEntry[] entries = new XdesEntry[256];

    public FspHeaderPage(PageHeader header) {
        super(header);
    }

    public FspHeaderPage() {
        super(new PageHeader());
    }

    @Override
    protected int write0(ByteBuffer stream) {
        return 0;
    }

    @Override
    public int read0(ByteBuffer stream) {
        return 0;
    }
}
