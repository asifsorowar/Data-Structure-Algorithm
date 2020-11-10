package com.asifsorowar.Stack;

import java.util.Stack;

public class StringReverse {
    public String StringReverse(String input){

        if (input == null) throw new IllegalStateException();

        Stack stack = new Stack();

        for (char ch: input.toCharArray()) {
            stack.push(ch);
        }

//        String reversed = "";

        StringBuffer reversed = new StringBuffer();

        while (!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
