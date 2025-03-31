package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;
import org.yyzx.mysql.sql.common.Item;

public class CondVisitor extends MySqlParserBaseVisitor<Item> {

    @Override
    public Item visitPredicateExpression(MySqlParser.PredicateExpressionContext ctx) {
        return ctx.predicate().accept(new PredicateVisitor());
    }
}
