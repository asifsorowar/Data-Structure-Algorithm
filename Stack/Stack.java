package com.asifsorowar.Stack;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[5];
    private int count;

    public void push(int item) {

        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i=0; i<count; i++){
                newItems[i] = items[i];
            }
            items = newItems;
        }

        items[count++] = item;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return items[--count];
    }

    public int peek() {
        return items[count-1];
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items,0,count);
        return Arrays.toString(content);
    }

    public boolean isEmpty() {
        return  (count == 0);
    }
}
