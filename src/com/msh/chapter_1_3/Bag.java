package com.msh.chapter_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * Created by weizhongjia on 2018/7/11.
 */
public class Bag<Item> implements Iterable<Item>{
    private Node first;
    private int N;

    public void add(Item item) {
        Node node = new Node();
        node.item = item;
        Node oldFirst = first;
        first = node;
        node.next = oldFirst;
        N++;
    }

    public boolean isEmpty() {
        return first == null;
    }

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

    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        while(!StdIn.isEmpty()) {
            bag.add(StdIn.readString());
        }
        Iterator<String> i = bag.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }
    }
}
