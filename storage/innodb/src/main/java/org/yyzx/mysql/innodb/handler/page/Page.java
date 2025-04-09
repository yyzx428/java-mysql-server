package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

public abstract class Page implements SerializablePage {

    private final PageHeader header;

    protected Page(PageHeader header) {
        this.header = header;
    }

    public PageHeader getHeader() {
        return header;
    }

    protected abstract int write0(ByteBuffer stream);

    public abstract int read0(ByteBuffer stream);

    @Override
    public final int write(ByteBuffer stream) {
        header.write(stream);
        return write0(stream);
    }

    @Override
    public final int read(ByteBuffer stream) {
        header.read(stream);
        return read0(stream);
    }
}
