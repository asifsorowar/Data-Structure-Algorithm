package com.asifsorowar.LinkList.KthValueFromEnd;

import java.util.LinkedList;

public class KthValueFromEnd {

    private LinkedList list;

    public KthValueFromEnd(LinkedList list) {
        this.list = list;
    }


    private class Node {
        private Node next;
        private int value;

        private Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;

    public int kthValueFromEnd(int k) {
        for (int i = 0; i < list.size(); i++) {
            Node node = new Node((Integer) list.get(i));

            if (first == null) {
                first = last = node;
            } else {
                last.next = node;
                last = node;
            }
        }


        var a = first;
        var b = first;

        for (int i = 0; i < k - 1; i++) {
            b = b.next;
            if (b == null) throw new IllegalStateException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;

    }

}
