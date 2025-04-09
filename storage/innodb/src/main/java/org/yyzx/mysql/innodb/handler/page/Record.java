package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

public class Record implements SerializablePage {

    private short nextRecord;

    private byte recordType;

    private byte owned;

    private short headNo;

    private byte nOwned;

    @Override
    public int write(ByteBuffer stream) {
        stream.putShort(nextRecord);
        stream.put(recordType);
        stream.put(owned);
        stream.putShort(headNo);
        stream.put(nOwned);
        return 0;
    }

    @Override
    public int read(ByteBuffer stream) {
        nextRecord = stream.getShort();
        recordType = stream.position(2).get();
        owned = stream.position(3).get();
        headNo = stream.position(4).getShort();
        nOwned = stream.position(6).get();
        return 0;
    }
}
