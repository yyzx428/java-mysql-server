package org.yyzx.mysql.innodb.handler.file;

import org.yyzx.mysql.innodb.handler.page.PageId;

public class FileTablespace {

    private final PageId pageId;

    private final FileNode node;

    public FileTablespace(PageId pageId, FileNode node) {
        this.pageId = pageId;
        this.node = node;
    }

    public FileNode findPageNo(int pageNo) {
        FileNode cur = node;

        while (null != cur){
            if(cur.getStartPage() > pageNo){
                return cur.getPrev();
            }
            cur = cur.getNext();
        }
        return cur;
    }
}
