package org.yyzx.mysql.innodb.handler.page;

public class InodeEntry {

    private long segId;

    private long notFullNUser;

    private TList free;

    private TList norFull;

    private TList full;

    private int magicNum;

    private int[] fragArr = new int[32];

}
