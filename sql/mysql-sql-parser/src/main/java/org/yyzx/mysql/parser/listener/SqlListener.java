package org.yyzx.mysql.parser.listener;

import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.antlr4.MySqlParserBaseListener;
import org.yyzx.mysql.parser.listener.select.ProjectionItemListener;
import org.yyzx.mysql.parser.visitor.CondVisitor;
import org.yyzx.mysql.parser.visitor.TableSourcesVisitor;
import org.yyzx.mysql.sql.common.Item;
import org.yyzx.mysql.sql.common.thread.LEX;
import org.yyzx.mysql.sql.common.enums.SqlTypeEnum;

public class SqlListener extends MySqlParserBaseListener {
    private final LEX lex;

    public SqlListener(LEX lex) {
        this.lex = lex;
    }

    @Override
    public void enterRoot(MySqlParser.RootContext ctx) {
        ctx.sqlStatements().enterRule(this);
    }

    @Override
    public void enterSqlStatements(MySqlParser.SqlStatementsContext ctx) {
        for (MySqlParser.SqlStatementContext sqlStatementContext : ctx.sqlStatement()) {
            sqlStatementContext.enterRule(this);
        }
    }

    @Override
    public void enterSqlStatement(MySqlParser.SqlStatementContext ctx) {
        ctx.dmlStatement().enterRule(this);
    }

    @Override
    public void enterDmlStatement(MySqlParser.DmlStatementContext ctx) {
        ctx.selectStatement().enterRule(this);
    }

    @Override
    public void enterSimpleSelect(MySqlParser.SimpleSelectContext ctx) {
        lex.setSqlType(SqlTypeEnum.SELECT);
        ctx.querySpecification().enterRule(this);
    }

    @Override
    public void enterQuerySpecification(MySqlParser.QuerySpecificationContext ctx) {
        ProjectionItemListener projection = new ProjectionItemListener();
        ctx.selectElements().enterRule(projection);
        lex.getSelectContext().addAllField(projection.getItems());

        ctx.fromClause().enterRule(this);
    }

    @Override
    public void enterFromClause(MySqlParser.FromClauseContext ctx) {
        lex.getSelectContext().addTables(ctx.tableSources().accept(new TableSourcesVisitor()));
        Item cond = ctx.expression().accept(new CondVisitor());
        lex.getSelectContext().setWhere(cond);
    }
}
