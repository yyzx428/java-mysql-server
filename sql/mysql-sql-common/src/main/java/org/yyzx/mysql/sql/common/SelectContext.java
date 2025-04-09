package org.yyzx.mysql.sql.common;

import java.util.LinkedList;
import java.util.List;

public class SelectContext {

    private List<Item> selectItem = new LinkedList<>();

    private List<Table> tables = new LinkedList<>();

    private Item where;

    public List<Item> getSelectItem() {
        return selectItem;
    }

    public void setSelectItem(List<Item> selectItem) {
        this.selectItem = selectItem;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public Item getWhere() {
        return where;
    }

    public void setWhere(Item where) {
        this.where = where;
    }

    public void addAllField(List<Item> items) {
        this.selectItem.addAll(items);
    }

    public void addTables(List<Table> tables) {
        this.tables.addAll(tables);
    }
}
