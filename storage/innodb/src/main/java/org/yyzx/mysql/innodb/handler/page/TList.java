package org.yyzx.mysql.innodb.handler.page;

public class TList {

    private int length;

    private Point first;

    private Point last;

    public int getLength() {
        return length;
    }

    public Point getFirst() {
        return first;
    }

    public Point getLast() {
        return last;
    }

    private static final class Point{
        private final int pageNo;

        private final short offset;

        public Point(int pageNo, short offset) {
            this.pageNo = pageNo;
            this.offset = offset;
        }
    }
}
