package org.yyzx.mysql.innodb.handler.table;

import org.yyzx.mysql.innodb.handler.file.DataFile;

import java.util.List;

public class Tablespace {

    private long spaceNo;

    private List<DataFile> files;


    public void setSpaceNo(int spaceNo) {

    }

    public DataFile getFirstDataFile() {
        return files.get(0);
    }
}
