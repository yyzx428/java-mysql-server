package org.yyzx.mysql.sql.common;

import org.yyzx.mysql.sql.common.table.TableDefinition;

public class CreateContext {

    private TableDefinition table;

    public TableDefinition getTable() {
        return table;
    }

    public void setTable(TableDefinition table) {
        this.table = table;
    }
}
