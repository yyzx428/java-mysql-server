package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;
import org.yyzx.mysql.sql.common.Item;
import org.yyzx.mysql.sql.common.field.ConstantItem;

public class ConstantVisitor extends MySqlParserBaseVisitor<Item> {

    @Override
    public Item visitConstant(MySqlParser.ConstantContext ctx) {
        return ctx.decimalLiteral().accept(this);
    }

    @Override
    public Item visitDecimalLiteral(MySqlParser.DecimalLiteralContext ctx) {
        return new ConstantItem(ctx.getText());
    }
}
