package org.yyzx.mysql.innodb.handler.page;

public class XdesEntry {

    private final long[] pageState = new long[2];
    private TList.Node point;
    private int state;
}
