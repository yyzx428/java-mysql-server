package org.yyzx.mysql.innodb.handler.page;

import java.nio.ByteBuffer;

public interface SerializablePage {

    /**
     * 写文件
     *
     * @param stream 流
     * @return 是否成功
     */
    int write(ByteBuffer stream);

    /**
     * 读取文件
     *
     * @param stream 流
     * @return int
     */
    int read(ByteBuffer stream);
}
