package org.yyzx.mysql.innodb.handler.index;

import org.yyzx.mysql.innodb.handler.field.InnodbField;

import java.util.List;

public class InnodbIndex {

    private long indexId;

    private int spaceNo;

    private int pageNo;

    private String indexName;

    private List<InnodbField> fields;

    private int rootPageNo;

    private int noLeafPageNo;

    public long getIndexId() {
        return indexId;
    }

    public int getSpaceNo() {
        return spaceNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public String getIndexName() {
        return indexName;
    }

    public List<InnodbField> getFields() {
        return fields;
    }

    public int getRootPageNo() {
        return rootPageNo;
    }

    public int getNoLeafPageNo() {
        return noLeafPageNo;
    }
}
