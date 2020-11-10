package com.asifsorowar.LinkList;

public class Main {
    public static void main(String[] args) {
        var link = new LinkList();
        link.addLast(10);
        link.addLast(20);
        link.addLast(30);
        link.addLast(40);
        link.addLast(50);
        System.out.println("Index of is: "+link.indexOf(10));
        System.out.println("Link size: "+link.size());

        System.out.println(link.getKthFromEnd(2));
        link.removeFirst();
        link.addFirst(10);
        link.reverse();

        System.out.println(link.toString());
    }
}

