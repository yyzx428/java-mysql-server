package org.yyzx.mysql.innodb.handler.table.enums;

public enum TablespaceTypeEnum {

    SYS(1);

    private final long type;

    TablespaceTypeEnum(long type) {
        this.type = type;
    }

    public long getType() {
        return type;
    }
}
