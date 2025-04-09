package org.yyzx.mysql.innodb.handler;

import org.yyzx.mysql.handler.Handler;
import org.yyzx.mysql.innodb.handler.table.Tablespace;
import org.yyzx.mysql.innodb.handler.table.TablespaceSystem;
import org.yyzx.mysql.sql.common.table.TableDefinition;

public class InnodbHandler implements Handler {


    @Override
    public void createTable(TableDefinition definition) {
        Tablespace tablespace = TablespaceSystem.INSTANCE.getTableSpace(definition.getTableName());
    }
}
