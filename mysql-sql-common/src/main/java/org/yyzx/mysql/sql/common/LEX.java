package org.yyzx.mysql.sql.common;

import java.util.LinkedList;
import java.util.List;

public class LEX {

    private String sqlType;

    private List<Item> selectItem = new LinkedList<>();

    private List<Table> tables = new LinkedList<>();

    private Item where;

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public List<Item> getSelectItem() {
        return selectItem;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setWhere(Item where) {
        this.where = where;
    }

    public Item getWhere() {
        return where;
    }

    public void addField(Item item) {
        selectItem.add(item);
    }

    public void addAllField(List<Item> items) {
        selectItem.addAll(items);
    }

    public void addTables(List<Table> tables) {
        this.tables.addAll(tables);
    }
}
