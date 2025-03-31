package org.yyzx.mysql.parser.listener.select;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseListener;
import org.yyzx.mysql.parser.visitor.FullColumnNameVisitor;
import org.yyzx.mysql.parser.visitor.FullIdVisitor;
import org.yyzx.mysql.parser.visitor.UidVisitor;
import org.yyzx.mysql.sql.common.Item;
import org.yyzx.mysql.sql.common.field.FieldItem;
import org.yyzx.mysql.sql.common.field.StartItem;

import java.util.LinkedList;
import java.util.List;

public class ProjectionItemListener extends MySqlParserBaseListener {

    private List<Item> items = new LinkedList<>();

    @Override
    public void enterSelectElements(MySqlParser.SelectElementsContext ctx) {
        TerminalNode star = ctx.STAR();
        if (null != star) {
            items.add(new StartItem());
        }

        for (MySqlParser.SelectElementContext selectElementContext : ctx.selectElement()) {
            selectElementContext.enterRule(this);
        }
    }

    @Override
    public void enterSelectStarElement(MySqlParser.SelectStarElementContext ctx) {

        List<String> fullIds = ctx.fullId().accept(new FullIdVisitor());

        StartItem startItem = new StartItem();
        if (!fullIds.isEmpty()) {
            startItem.setTableAlias(fullIds.get(0));
        }

        items.add(startItem);
    }

    @Override
    public void enterSelectColumnElement(MySqlParser.SelectColumnElementContext ctx) {
        FieldItem fieldItem = new FieldItem();

        String fieldName = ctx.uid().accept(new UidVisitor());
        fieldItem.setColumnName(fieldName);

        if (ctx.AS() != null) {
            List<String> names = ctx.fullColumnName().accept(new FullColumnNameVisitor());
            if (!names.isEmpty()) {
                fieldItem.setColumnName(names.get(0));
            }
            fieldItem.setAlias(fieldName);
        }

        items.add(fieldItem);
    }

    public List<Item> getItems() {
        return items;
    }
}
