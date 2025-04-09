package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

public class InodePage extends Page {

    private TList.Node inodePageNode;

    private InodeEntry[] entries = new InodeEntry[85];

    public InodePage(PageHeader header) {
        super(header);
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
