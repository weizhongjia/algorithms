package com.msh.chapter_1_3;

/**
 * Created by weizhongjia on 2018/7/11.
 */
public interface IStack<Item> {
    void push(Item item);
    Item pop();
    boolean isEmpty();
    int size();
}
