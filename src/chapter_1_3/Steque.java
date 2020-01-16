package chapter_1_3;

import edu.princeton.cs.algs4.StdOut;

public class Steque<Item> {
    private Node first;
    private Node last;
    private int N;
    private class Node {
        Item item;
        Node next;
    }

    public void push (Item item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (last == null) {
            last = first;
        }
        N++;
    }

    public Item pop () {
        if (first == null) {
            throw new IllegalStateException("栈队列为空");
        }
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }
        N--;
        return item;
    }

    public void enqueue (Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (oldLast == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(0);
        steque.push(1);
        steque.enqueue(2);
        steque.enqueue(3);
        steque.enqueue(4);
        for (int i = 0;i < 5;i++) {
            StdOut.println(steque.pop());
        }
    }
}
