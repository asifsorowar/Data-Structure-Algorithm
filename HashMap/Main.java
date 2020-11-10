package com.asifsorowar.HashMap;

public class Main {

    public static void main(String[] args) {
        HashTable hash = new HashTable();

        hash.put(1, "Asif");
        hash.put(2, "Ayon");

        System.out.println(hash.get(1));
    }

}
