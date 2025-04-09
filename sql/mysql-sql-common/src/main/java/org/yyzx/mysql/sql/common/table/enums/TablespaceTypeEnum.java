package org.yyzx.mysql.sql.common.table.enums;

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
