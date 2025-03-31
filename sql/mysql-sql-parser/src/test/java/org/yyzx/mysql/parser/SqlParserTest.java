package org.yyzx.mysql.parser;

import org.yyzx.mysql.sql.common.LEX;

public class SqlParserTest {

    public static void main(String[] args) {
        LEX lex = new LEX();
        new SqlParser().parserSql("select name as nameA,t.* from t_interest t where id = 1", lex);
        System.err.println();
    }
}
