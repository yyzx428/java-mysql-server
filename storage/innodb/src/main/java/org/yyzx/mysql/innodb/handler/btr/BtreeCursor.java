package org.yyzx.mysql.innodb.handler.btr;

import org.yyzx.mysql.innodb.handler.index.InnodbIndex;

public class BtreeCursor {

    private final InnodbIndex index;

    public BtreeCursor(InnodbIndex index) {
        this.index = index;
    }
}
