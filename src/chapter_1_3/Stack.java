package chapter_1_3;

import java.util.Iterator;

/**
 * Created by weizhongjia on 2018/7/11.
 */
public class Stack<Item> implements IStack<Item>, Iterable<Item> {
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

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item> {

        private Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Node current = currentNode;
            currentNode = currentNode.next;
            return current.item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }
}
