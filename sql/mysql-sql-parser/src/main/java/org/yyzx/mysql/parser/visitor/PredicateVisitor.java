package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;
import org.yyzx.mysql.sql.common.Item;
import org.yyzx.mysql.sql.common.expression.PredicateItem;
import org.yyzx.mysql.sql.common.expression.enums.OperationEnum;
import org.yyzx.mysql.sql.common.field.FieldItem;

import java.util.List;

public class PredicateVisitor extends MySqlParserBaseVisitor<Item> {

    @Override
    public Item visitBinaryComparisonPredicate(MySqlParser.BinaryComparisonPredicateContext ctx) {
        Item left = ctx.left.accept(this);
        Item right = ctx.right.accept(this);
        String operation = ctx.comparisonOperator().accept(new UidVisitor());
        OperationEnum operationEnum = OperationEnum.codeOf(operation);
        if (OperationEnum.EQ == operationEnum) {
            return new PredicateItem.Eq(left, right);
        }
        throw new IllegalArgumentException("暂时不支持" + operation + "操作符");
    }

    @Override
    public Item visitFullColumnNameExpressionAtom(MySqlParser.FullColumnNameExpressionAtomContext ctx) {
        List<String> names = ctx.fullColumnName().accept(new FullColumnNameVisitor());
        FieldItem fieldItem = new FieldItem();

        int size = names.size();
        if (size == 1) {
            fieldItem.setColumnName(names.get(0));
        } else if (size == 2) {
            fieldItem.setTableAlias(names.get(0));
            fieldItem.setColumnName(names.get(1));
        }

        return fieldItem;
    }

    @Override
    public Item visitConstantExpressionAtom(MySqlParser.ConstantExpressionAtomContext ctx) {
        return ctx.constant().accept(new ConstantVisitor());
    }
}
