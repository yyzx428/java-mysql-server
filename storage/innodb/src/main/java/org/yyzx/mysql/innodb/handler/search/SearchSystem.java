package org.yyzx.mysql.innodb.handler.search;

import org.yyzx.mysql.innodb.handler.dict.DictSysSystem;
import org.yyzx.mysql.innodb.handler.index.InnodbIndex;
import org.yyzx.mysql.innodb.handler.table.Tablespace;

public class SearchSystem {

    public final static SearchSystem INSTANCE = new SearchSystem();

    public Tablespace searchTableByKey(Tuple tableName) {
        InnodbIndex index = DictSysSystem.INSTANCE.getSysTableFirstIndex();


        return null;
    }
}
