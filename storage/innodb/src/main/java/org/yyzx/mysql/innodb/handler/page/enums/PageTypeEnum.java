package org.yyzx.mysql.innodb.handler.page.enums;

public enum PageTypeEnum {
    FSP(0);

    private final int type;

    PageTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
