package org.yyzx.mysql.innodb.handler.dict;

import org.yyzx.mysql.innodb.handler.index.InnodbIndex;
import org.yyzx.mysql.innodb.handler.table.InnodbTable;

public class DictSysSystem {

    public static final DictSysSystem INSTANCE = new DictSysSystem();

    private InnodbTable SYS_TABLES;

    public InnodbIndex getSysTableFirstIndex(){
        return INSTANCE.SYS_TABLES.getFirstIndex();
    }
}
