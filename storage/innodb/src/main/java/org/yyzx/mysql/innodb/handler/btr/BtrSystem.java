package org.yyzx.mysql.innodb.handler.btr;

import org.yyzx.mysql.innodb.handler.buf.BufSystem;
import org.yyzx.mysql.innodb.handler.buf.BufferPage;
import org.yyzx.mysql.innodb.handler.index.InnodbIndex;
import org.yyzx.mysql.innodb.handler.page.PageId;

public class BtrSystem {

    public static final BtrSystem INSTANCE = new BtrSystem();


    public BtreeCursor openCursor(InnodbIndex index) {
        BtreeCursor cursor = new BtreeCursor(index);
        BufferPage page = BufSystem.INSTANCE.getBuf(new PageId(index.getSpaceNo(), index.getPageNo()));


        return cursor;
    }
}
