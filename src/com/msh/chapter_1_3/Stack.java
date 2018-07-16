package com.msh.chapter_1_3;

/**
 * Created by weizhongjia on 2018/7/11.
 */
public class Stack<Item> implements IStack<Item> {
    private Node first;
    private int N;

    @Override
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        Node oldFirst = first;
        first = node;
        node.next = oldFirst;
        N++;
    }

    @Override
    public Item pop() {
        if (first == null) {
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if (first == null) {
            return null;
        }
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return N;
    }

    private class Node {
        Item item;
        Node next;
    }
}
