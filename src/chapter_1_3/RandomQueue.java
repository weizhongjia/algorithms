package chapter_1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomQueue<Item> implements Iterable<Item>{
    private Item[] arr;
    private int N;

    public RandomQueue() {
        arr = (Item[]) new Object[1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void enqueue(Item item) {
        if (N == arr.length) {
            resize(arr.length * 2);
        }
        arr[N++] = item;
    }

    public Item dequeue() {
        int index = StdRandom.uniform(N);
        Item item = arr[index];
        arr[index] = arr[--N];
        if (N > 0 && N == arr.length / 4) {
            resize(arr.length / 2);
        }
        return item;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public static void main(String[] args) {
        RandomQueue<Integer> rq = new RandomQueue<>();
        while (!StdIn.isEmpty()) {
            rq.enqueue(StdIn.readInt());
        }
        StdOut.println("=======");
        Iterator i = rq.iterator();
        while (i.hasNext()) {
            StdOut.println(i.next());
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }

    private class RandomIterator implements Iterator<Item> {

        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            int index = StdRandom.uniform(i);
            Item item = arr[index];
            arr[index] = arr[--i];
            arr[i] = item;
            return item;
        }
    }
}
