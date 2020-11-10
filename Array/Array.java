package com.asifsorowar.Array;

import java.util.Arrays;

public class Array {
    private int[] items;
    private int[] newItems;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {

        if (items.length == count) {
            newItems = new int[count *2];

            for (int i=0; i<count; i++) {
                newItems[i] = items[i];
            }
        }

        items[count++] = item;
    }

    public void removeAt(int index) {

        if (index<0 || index>= count)
            throw new IllegalArgumentException();

        for (int i = index; i<count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexof(int item) {
        for (int i=0; i<count; i++) {
            if (items[i] == item)
                return i;
        }

        return -1;
    }

    public void print() {
        for (int i=0; i<count; i++) {
            System.out.println(items[i]);
        }
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(content);
    }

}
