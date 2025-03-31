package org.yyzx.mysql.sql.common.field;

import org.yyzx.mysql.sql.common.Item;

public class ConstantItem implements Item {

    private String constant;

    public ConstantItem(String constant) {
        this.constant = constant;
    }


}
