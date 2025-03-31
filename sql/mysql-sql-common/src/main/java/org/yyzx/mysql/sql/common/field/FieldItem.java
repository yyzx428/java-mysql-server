package org.yyzx.mysql.sql.common.field;

import org.yyzx.mysql.sql.common.Item;

public class FieldItem implements Item {

    private String columnName;

    private String alias;

    private String tableAlias;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
}
