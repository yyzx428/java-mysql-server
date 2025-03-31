package org.yyzx.mysql.sql.common.field;

import org.yyzx.mysql.sql.common.Item;

public class StartItem implements Item {

    private String tableAlias;

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
}
