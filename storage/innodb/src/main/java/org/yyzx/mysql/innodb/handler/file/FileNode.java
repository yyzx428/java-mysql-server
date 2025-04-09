package org.yyzx.mysql.innodb.handler.file;

import java.nio.channels.FileChannel;

public class FileNode {

    private String fileName;

    private int startPage;

    private int pageSize;

    private FileChannel fd;

    private FileNode next;

    private FileNode prev;

    public String getFileName() {
        return fileName;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public FileNode getNext() {
        return next;
    }

    public FileNode getPrev() {
        return prev;
    }

    public FileChannel getFd() {
        return fd;
    }
}
