package com.msh.chapter_1_3;

import com.msh.chapter_1_3.Stack;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.regex.Pattern;

/**
 * Created by weizhongjia on 2018/7/12.
 */
public class Parentheses {

    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == LEFT_BRACE || aChar == LEFT_BRACKET || aChar == LEFT_PAREN) {
                stack.push(aChar);
            }
            if (aChar == RIGHT_PAREN) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_PAREN) {
                    return false;
                }
            }
            if (aChar == RIGHT_BRACE) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_BRACE) {
                    return false;
                }
            }
            if (aChar == RIGHT_BRACKET) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.pop() != LEFT_BRACKET) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");
    public static void main(String[] args) {
        In in = new In();
        String s = in.readAll().trim();
        StdOut.println(isBalanced(s));
    }
}
