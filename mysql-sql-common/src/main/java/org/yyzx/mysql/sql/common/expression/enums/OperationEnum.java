package org.yyzx.mysql.sql.common.expression.enums;

public enum OperationEnum {

    EQ("=");

    private final String operation;

    OperationEnum(String operation) {
        this.operation = operation;
    }

    public static OperationEnum codeOf(String code){
        for (OperationEnum value : OperationEnum.values()) {
            if(value.operation.equals(code)){
                return value;
            }
        }
        return null;
    }
}
