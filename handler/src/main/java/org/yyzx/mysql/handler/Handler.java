package org.yyzx.mysql.handler;

import org.yyzx.mysql.sql.common.table.TableDefinition;

/**
 * 存储引擎接口
 */
public interface Handler {

    /**
     * 创建表
     *
     * @param definition 表定义
     */
    void createTable(TableDefinition definition);
}
