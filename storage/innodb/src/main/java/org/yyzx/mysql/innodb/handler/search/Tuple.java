package org.yyzx.mysql.innodb.handler.search;

import java.nio.ByteBuffer;

public class Tuple {

    private final ByteBuffer keyParts;

    public Tuple(ByteBuffer keyParts) {
        this.keyParts = keyParts;
    }

    public static Tuple by(String key) {
        return new Tuple(ByteBuffer.wrap(key.getBytes()));
    }
}
