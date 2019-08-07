package com.company.ch07_Heap_and_PriorityQueue;

import java.util.Random;

public class Main {
    public static void testMaxHeap(){
        int n=1000000;

        MaxHeap<Integer> maxHeap=new MaxHeap<>();
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] arr=new int[maxHeap.size()];
        for (int i = 0; i < maxHeap.size(); i++) {
            arr[i]=maxHeap.extractMax();
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1]<arr[i])
                throw new IllegalArgumentException("Error");
        }

        System.out.println("Test MaxHeap completed.");

    }
    public static void main(String[] args) {
        testMaxHeap();
    }
}
