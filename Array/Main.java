package com.asifsorowar.Array;

public class Main {
    public static void main(String[] args) {
        var array = new Array(5);

        array.insert(10);
        array.insert(20);
        array.insert(30);

        System.out.println(array.indexof(10));

        array.removeAt(0);

        array.print();
        System.out.println(array.toString());
    }
}

