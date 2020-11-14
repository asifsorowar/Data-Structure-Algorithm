package com.asifsorowar.Heap;

import java.util.Arrays;

public class HeapMain {
    public static void main(String[] args) {
        var heap = new Heap();
        heap.insert(50);
        heap.insert(40);
        heap.insert(60);

        var priority = new PriorityQueueWithHeap();

        priority.enqueue(1);
        priority.enqueue(5);
        priority.enqueue(8);
        priority.enqueue(3);
        priority.enqueue(9);

        System.out.println(priority);

        int[] numbers = {1, 5, 8, 3, 9, 2};
        MaxHeap.heapify(numbers);
        System.out.println(MaxHeap.getKthLargest(numbers, 2));
        System.out.println(Arrays.toString(numbers));
    }
}
