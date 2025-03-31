package org.yyzx.mysql.parser.visitor;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseVisitor;
import org.yyzx.mysql.sql.common.Table;

import java.util.LinkedList;
import java.util.List;

public class TableSourcesVisitor extends MySqlParserBaseVisitor<List<Table>> {

    @Override
    public List<Table> visitTableSources(MySqlParser.TableSourcesContext ctx) {
        List<Table> tables = new LinkedList<>();

        for (MySqlParser.TableSourceContext tableSourceContext : ctx.tableSource()) {
            Table table = tableSourceContext.accept(new MySqlParserBaseVisitor<Table>() {
                final Table table = new Table();

                @Override
                public Table visitTableSourceBase(MySqlParser.TableSourceBaseContext ctx) {
                    ctx.tableSourceItem().accept(this);
                    return table;
                }

                @Override
                public Table visitAtomTableItem(MySqlParser.AtomTableItemContext ctx) {
                    ctx.tableName().accept(this);
                    String alias = ctx.alias.accept(new UidVisitor());
                    table.setAlias(alias);
                    return null;
                }

                @Override
                public Table visitTableName(MySqlParser.TableNameContext ctx) {
                    List<String> names = ctx.fullId().accept(new FullIdVisitor());
                    if (!names.isEmpty()) {
                        table.setName(names.get(0));
                    }
                    return null;
                }
            });

            tables.add(table);
        }
        return tables;
    }
}
