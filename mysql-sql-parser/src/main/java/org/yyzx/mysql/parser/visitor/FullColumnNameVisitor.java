package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;

import java.util.LinkedList;
import java.util.List;

public class FullColumnNameVisitor extends MySqlParserBaseVisitor<List<String>> {

    @Override
    public List<String> visitFullColumnName(MySqlParser.FullColumnNameContext ctx) {
        List<String> names = new LinkedList<>();
        String name = ctx.uid().accept(new UidVisitor());
        names.add(name);
        for (MySqlParser.DottedIdContext dottedIdContext : ctx.dottedId()) {
            String current = dottedIdContext.accept(new UidVisitor());
            names.add(current);
        }
        return names;
    }
}
