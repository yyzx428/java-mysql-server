package org.yyzx.mysql.sql.common.thread;

import org.yyzx.mysql.sql.common.CreateContext;
import org.yyzx.mysql.sql.common.SelectContext;
import org.yyzx.mysql.sql.common.enums.SqlTypeEnum;

public class LEX {

    private SqlTypeEnum sqlType;

    private SelectContext selectContext;

    private CreateContext createContext;

    public SqlTypeEnum getSqlType() {
        return sqlType;
    }

    public void setSqlType(SqlTypeEnum sqlType) {
        this.sqlType = sqlType;
        if (SqlTypeEnum.SELECT == sqlType) {
            this.selectContext = new SelectContext();
        }
    }

    public SelectContext getSelectContext() {
        return selectContext;
    }

    public void setSelectContext(SelectContext selectContext) {
        this.selectContext = selectContext;
    }

    public CreateContext getCreateContext() {
        return createContext;
    }

    public void setCreateContext(CreateContext createContext) {
        this.createContext = createContext;
    }
}
