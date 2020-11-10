package com.asifsorowar;

import java.util.*;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {

        Queue queue = new ArrayDeque();

        queue.add(10);

        queue.add(20);
        queue.add(30);

        reverse(queue);

        System.out.println(queue);

    }
    public static void reverse(Queue<Integer> queue) {
        Stack stack = new Stack();

        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add((Integer) stack.pop());
    }
}
