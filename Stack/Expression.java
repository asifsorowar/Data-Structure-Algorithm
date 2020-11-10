package com.asifsorowar.Stack;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private List leftBracket = Arrays.asList('(', '{', '<', '[');
    private List rightBracket = Arrays.asList(')', '}', '>', ']');


    public boolean isBalance(String input) {
        Stack stack = new Stack();

        for (char ch: input.toCharArray()) {

            if (isLeftBracket(ch)) {
                stack.push(ch);
            }

            if (isRightBracket(ch)) {
                if (stack.isEmpty()) return false;

                var top = stack.pop();

                if (!isMatch((Character) top, ch)) return false;


            }

        }

        return  stack.isEmpty();
    }

    private boolean isRightBracket(char ch) {
        return rightBracket.contains(ch);

    }


    private boolean isLeftBracket(char ch) {
        return leftBracket.contains(ch);
    }

    private boolean isMatch(char left, char right) {
        return  (rightBracket.indexOf(right) == leftBracket.indexOf(left));
    }



}
