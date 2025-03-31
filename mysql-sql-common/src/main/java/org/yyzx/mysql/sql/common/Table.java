package org.yyzx.mysql.sql.common;

public class Table {

    private String name;

    private String alias;

    private byte[][] records;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[][] getRecords() {
        return records;
    }

    public void setRecords(byte[][] records) {
        this.records = records;
    }
}
