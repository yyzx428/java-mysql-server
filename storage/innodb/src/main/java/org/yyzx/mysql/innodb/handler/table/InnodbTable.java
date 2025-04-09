package org.yyzx.mysql.innodb.handler.table;

import org.yyzx.mysql.innodb.handler.index.InnodbIndex;

import java.util.List;

public class InnodbTable {

    private String tableName;

    private List<InnodbIndex> indexes;

    public List<InnodbIndex> getIndexes() {
        return indexes;
    }

    public InnodbIndex getFirstIndex() {
        return indexes.get(0);
    }
}
