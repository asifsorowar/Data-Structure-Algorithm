package com.asifsorowar.LinkList;

import java.util.Arrays;

public class LinkList {
    private class Node {
        private Node next;
        private int value;

        private Node(int value) {
            this.value = value;
        }
    }


    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {

        Node node = new Node(item);

        if(this.isEmpty()) {
            first = last = node;
        }
        else {
            node.next = first;
            first = node;
        }

        size++;

    }

    public void addLast(int item) {
        var node = new Node(item);

        if(this.isEmpty()) {
            first = last = node;
        }
        else {
            last.next = node;
            last = node;
        }

        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        var current = first;
        while (current != null) {
            if (current.value == item)
                return index;
            current = current.next;
            index++;
        }

//        for (int i=0; current != null; i++) {
//            if (current.value == item) return i;
//
//            current = current.next;
//        }

        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }

        size--;

        if (first==last) {
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
    }

    public void removeLast() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }

        size--;

        if (first==last) {
            first = last = null;
            return;
        }

        var previous = this.getPrevious(last);
        last = previous;
        last.next = null;
    }

    public void removeAt(int index) {
        if (isEmpty()) {
            first = last = null;
        }

        size--;

        if (first == last) {
            first = last = null;
            return;
        }


        var current = first;
        while (current != null) {
            if (indexOf(current.value) == index) break;
            current = current.next;
        }

        var currentNext = current.next;

        var previous = getPrevious(current);
        previous.next = currentNext;

        current.next = null;


    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] array = new int[size];
        var current = first;
        int index = 0;

        while (current != null) {
            array[index] = current.value;

            current = current.next;
            index++;
        }

        return array;
    }

    public int getKthFromEnd(int k) {
        if(isEmpty()) throw new IllegalStateException();

        var a = first;
        var b = first;

        for (int i=0; i< k-1; i++) {
            b = b.next;
            if (b == null) throw new IllegalStateException();
        }

        while (b != last) {
            a = a.next;
            b = b.next;
        }

        return a.value;

    }

    public void reverse() {

        if (isEmpty()) {
            return;
        }

        var previous = first;
        var current = previous.next;

        while (current != null) {

            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }

    @Override
    public String toString() {
        var list = this.toArray();
        return Arrays.toString(list);
    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private boolean isEmpty() {
         return first == null;
    }

}
