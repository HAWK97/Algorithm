package com.hawk.dataStructure.stack;

import java.util.Iterator;

// 能够动态调整数组大小的下压栈
// Item是类型参数，也可以使用其他大写字母
public class ResizingArrayStack<Item> implements Iterable<Item> {
    // Java 定义数组需指定数组容量
    private Item[] a = (Item[]) new Object[1];
    // 栈中元素个数
    private int N;

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void resize(int max) {
        // 将大小为N <= max的栈移动到一个新的大小为max的数组中
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        // 先赋值给a[N]（在push前栈中最后一个元素为a[N - 1]），再执行N++
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public static void main(String[] args) {
        ResizingArrayStack<String> s = new ResizingArrayStack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        for (String str : s) {
            System.out.println(str);
        }
    }
}
