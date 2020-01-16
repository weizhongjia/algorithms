package chapter_1_3;

import edu.princeton.cs.algs4.StdOut;

public class Deque<Item> implements IDeque<Item> {
    private Node left;
    private Node right;
    private int N;
    private class Node {
        Item item;
        Node left;
        Node right;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size () {
        return N;
    }

    public void pushLeft (Item item) {
        Node oldLeft = left;
        left = new Node();
        left.item = item;
        left.right = oldLeft;
        if (oldLeft == null) {
            right = left;
        } else {
            oldLeft.left = left;
        }
        N++;
    }

    public void pushRight (Item item) {
        Node oldRight = right;
        right = new Node();
        right.left = oldRight;
        right.item = item;
        if (oldRight == null) {
            left = right;
        } else {
            oldRight.right = right;
        }
        N++;
    }

    public Item popLeft() {
        if (left == null) {
            throw new IllegalStateException("双向队列为空");
        }
        Item item = left.item;
        left = left.right;
        if (left != null) {
            left.left = null;
        } else {
            right = null;
        }
        N--;
        return item;
    }

    public Item popRight() {
        if (right == null) {
            throw new IllegalStateException("双向队列为空");
        }
        Item item = right.item;
        right = right.left;
        if (right == null) {
            left = null;
        } else {
            right.right = null;
        }
        N--;
        return item;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();
        deque.pushLeft(0);
        deque.pushRight(1);
        deque.pushRight(2);
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushRight(5);
        deque.pushRight(6);
        deque.pushLeft(7);
        for (int i = 0;i<8;i++) {
            StdOut.println(deque.popRight());
        }
    }
}
