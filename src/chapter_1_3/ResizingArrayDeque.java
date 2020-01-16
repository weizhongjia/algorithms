package chapter_1_3;

import edu.princeton.cs.algs4.StdOut;

public class ResizingArrayDeque<Item> implements IDeque<Item>{

    private Item[] array;
    private int left;
    private int right;
    private int N;

    public ResizingArrayDeque() {
        array = (Item[]) new Object[4];
        left = 1;
        right = 2;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void pushLeft(Item item) {
        if (N >= array.length / 2) {
            resize(array.length * 2);
        }
        array[left] = item;
        N++;
        left--;
    }

    @Override
    public void pushRight(Item item) {
        if (N >= array.length / 2) {
            resize(array.length * 2);
        }
        array[right] = item;
        N++;
        right++;
    }

    @Override
    public Item popLeft() {
        if (N <= array.length / 4) {
            resize(array.length / 2);
        }
        Item item = array[++left];
        array[left] = null;
        N--;
        return item;
    }

    @Override
    public Item popRight() {
        if (N <= array.length / 4) {
            resize(array.length / 2);
        }
        Item item = array[--right];
        array[right] = null;
        N--;
        return item;
    }

    private void resize (int length) {
        if (length < N) {
            throw new IllegalStateException("不能更改数组大小");
        }
        if (length < 4) {
            length = 4;
        }
        Item[] oldArray = array;
        int oldLeft = left;
        array = (Item[]) new Object[length];
        left = length / 4;
        int j = left + 1;
        for (int i = oldLeft + 1;i < right; i++, j++) {
            array[j] = oldArray[i];
        }
        right = j;
    }

    public static void main(String[] args) {
        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushLeft(0);
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushLeft(5);
        deque.pushLeft(6);
        deque.pushLeft(7);
        deque.pushLeft(0);
        deque.pushLeft(1);
        deque.pushLeft(2);
        deque.pushLeft(3);
        deque.pushLeft(4);
        deque.pushLeft(5);
        deque.pushLeft(6);
        deque.pushLeft(7);
        while (!deque.isEmpty()) {
            StdOut.println(deque.popRight());
        }
    }
}
