package org.yyzx.mysql.parser;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.yyzx.mysql.parser.antlr4.MySqlLexer;
import org.yyzx.mysql.parser.antlr4.MySqlParser;
import org.yyzx.mysql.parser.listener.SqlListener;
import org.yyzx.mysql.sql.common.LEX;

public class SqlParser {

    public void parserSql(String sql, LEX lex) {
        CodePointCharStream stream = CharStreams.fromString(sql);
        MySqlLexer lexer = new MySqlLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MySqlParser parser = new MySqlParser(tokens);
        MySqlParser.RootContext root = parser.root();
        SqlListener sqlListener = new SqlListener(lex);
        root.enterRule(sqlListener);
    }
}
