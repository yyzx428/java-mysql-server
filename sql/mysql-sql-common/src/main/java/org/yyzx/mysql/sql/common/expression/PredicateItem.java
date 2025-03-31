package org.yyzx.mysql.sql.common.expression;

import org.yyzx.mysql.sql.common.Item;

public abstract class PredicateItem extends ExpressionItem {

    protected final Item left;

    protected final Item right;

    public PredicateItem(Item left, Item right) {
        this.left = left;
        this.right = right;
    }

    public static class Eq extends PredicateItem {

        public Eq(Item left, Item right) {
            super(left, right);
        }

        @Override
        public int getVal() {
            return left.getVal() == right.getVal() ? 1 : 0;
        }
    }
}
