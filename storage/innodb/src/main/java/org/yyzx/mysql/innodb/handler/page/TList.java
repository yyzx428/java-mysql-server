package org.yyzx.mysql.innodb.handler.page;

public class TList {

    private int length;

    private Node node;

    public int getLength() {
        return length;
    }

    public Node getNode() {
        return node;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public static final class Node{
        private Point prev;

        private Point next;
    }

    public static final class Point {
        private final int pageNo;

        private final short offset;

        public Point(int pageNo, short offset) {
            this.pageNo = pageNo;
            this.offset = offset;
        }
    }
}
