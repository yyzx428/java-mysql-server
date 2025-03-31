package org.yyzx.mysql.sql.common;

public interface Item {

    /**
     * @return 获取值
     */
    default int getVal() {
        return 0;
    }
}
