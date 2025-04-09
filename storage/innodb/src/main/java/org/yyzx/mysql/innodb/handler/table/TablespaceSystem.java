package org.yyzx.mysql.innodb.handler.table;

import org.yyzx.mysql.innodb.handler.search.SearchSystem;
import org.yyzx.mysql.innodb.handler.search.Tuple;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TablespaceSystem {

    public static final TablespaceSystem INSTANCE = new TablespaceSystem();

    private final Map<String, Tablespace> NAME_MAP = new ConcurrentHashMap<>();


    public Tablespace getTableSpace(String tableName) {
        Tablespace tablespace = NAME_MAP.get(tableName);
        if (null == tablespace) {
            tablespace = SearchSystem.INSTANCE.searchTableByKey(Tuple.by(tableName));
        }
        return null;
    }
}
