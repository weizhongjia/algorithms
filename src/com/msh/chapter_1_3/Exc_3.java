package com.msh.chapter_1_3;

import edu.princeton.cs.algs4.StdOut;

public class Exc_3 {
    public static void main(String[] args) {
        int[][] testData = {{4, 3, 2, 1, 0, 9, 8, 7, 6, 5}
                ,{4, 6, 8, 7, 5, 3, 2, 9, 0, 1}
                ,{2, 5, 6, 7, 4, 8, 9, 3, 1, 0}
                ,{4, 3, 2, 1, 0, 5, 6, 7, 8, 9}};
        for (int i = 0; i < testData.length; i++) {
            ResizeingArrayStack<Integer> stack = new ResizeingArrayStack<Integer>();
            int currentStackData = -1;
            for (int j = 0; j < testData[i].length; j++) {
                while (currentStackData < testData[i][j]) {
                    stack.push(++currentStackData);
                }
                if (testData[i][j] == stack.peek()) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                StdOut.println("row " + i + " is correct");
            } else {
                StdOut.println("row " + i + " is not correct");
            }

        }
    }
}
