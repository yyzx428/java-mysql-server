package org.yyzx.mysql.parser.visitor;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class UidVisitor extends MySqlParserBaseVisitor<String> {

    @Override
    public String visitDottedId(MySqlParser.DottedIdContext ctx) {
        return ctx.uid().accept(this);
    }

    @Override
    public String visitUid(MySqlParser.UidContext ctx) {
        return ctx.simpleId().accept(this);
    }

    @Override
    public String visitKeywordsCanBeId(MySqlParser.KeywordsCanBeIdContext ctx) {
        int count = ctx.getChildCount();
        List<String> uid = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            ParseTree child = ctx.getChild(i);
            uid.add(child.accept(this));
        }
        return String.join(",", uid);
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        return node.getText();
    }
}
