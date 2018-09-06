package com.hawk.dataStructure.list;

public class DoubleLink<Item> {
    private Node head;
    private int N;

    private class Node {
        Node prev;
        Node next;
        Item item;

        public Node(Item item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public DoubleLink() {
        // 一定注意：表头没有存储数据！
        head = new Node(null, null, null);
        head.prev = head.next = head;
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // 获取第index位置的节点
    private Node getNode(int index) {
        if (index < 0 || index >= N) {
            throw new IndexOutOfBoundsException();
        }
        if (index <= N / 2) {
            Node node = head.next;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
        Node rnode = head.prev;
        int rindex = N - index - 1;
        for (int j = 0; j < rindex; j++) {
            rnode = rnode.prev;
        }
        return rnode;
    }

    public Item get(int index) {
        return getNode(index).item;
    }

    public Item getFirst() {
        return getNode(0).item;
    }

    public Item getLast() {
        return getNode(N - 1).item;
    }

    // 将节点插入到第index位置之前
    public void insert(int index, Item item) {
        if (index == 0) {
            Node node = new Node(item, head, head.next);
            head.next.prev = node;
            head.next = node;
            N++;
            return;
        }
        Node inode = getNode(index);
        Node tnode = new Node(item, inode.prev, inode);
        inode.prev.next = tnode;
        inode.prev = tnode;
        N++;
    }

    public void insertFirst(Item item) {
        insert(0, item);
    }

    // 将节点添加到链表的末尾
    public void appendLast(Item item) {
        Node node = new Node(item, head.prev, head);
        head.prev.next = node;
        head.prev = node;
        N++;
    }

    // 删除index位置的节点
    public void del(int index) {
        Node node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node = null;
        N--;
    }

    public void delFirst() {
        del(0);
    }

    public void delLast() {
        del(N - 1);
    }

    public static void main(String[] args) {
        DoubleLink<Integer> dlink = new DoubleLink<>();
        dlink.insert(0, 20);
        dlink.appendLast(30);
        dlink.insertFirst(10);
        for (int i = 0; i < dlink.size(); i++) {
            System.out.println(dlink.get(i));
        }
    }
}
