package com.asifsorowar.Heap;

import java.util.Arrays;

public class PriorityQueueWithHeap {
    private Heap heap = new Heap();

    public void enqueue(int value) {
        heap.insert(value);
    }

    public int dequeue() {
        return heap.remove();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public String toString() {
        return heap.toString() ;
    }
}
