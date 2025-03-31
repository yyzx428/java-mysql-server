package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;

import java.util.LinkedList;
import java.util.List;

public class FullIdVisitor extends MySqlParserBaseVisitor<List<String>> {

    private final UidVisitor uidVisitor = new UidVisitor();

    @Override
    public List<String> visitFullId(MySqlParser.FullIdContext ctx) {
        List<String> result = new LinkedList<>();
        for (MySqlParser.UidContext uidContext : ctx.uid()) {
            String uid = uidContext.accept(uidVisitor);
            result.add(uid);
        }
        return result;
    }
}
