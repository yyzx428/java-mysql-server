package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;
import java.util.List;

public class IndexPage extends Page {

    private List<Record> records;

    private short[] directory;

    protected IndexPage(PageHeader header) {
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
