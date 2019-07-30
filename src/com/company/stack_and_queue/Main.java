package com.company.stack_and_queue;

import com.company.Array.Array;

import java.util.Random;

public class Main {
    public static void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    public static void testArrayQueue() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 1; i < 11; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }

        while(!queue.isEmpty()){
            queue.dequeue();
            System.out.println(queue);
        }
    }

    public static void testLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==0){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public static void testTimeComplexity(){
        int opCount=100000;

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1=timeDiff(loopQueue,opCount);
        System.out.println("LoopQueue,time: "+time1+" s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time2=timeDiff(arrayQueue,opCount);
        System.out.println("ArrayQueue,time: "+time2+" s");
    }

    public static double timeDiff(Queue<Integer> queue,int opCount){
        long starTime =System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }
        long endTime=System.nanoTime();
        return (endTime-starTime)/1000000000.0;
    }
    public static void main(String[] args) {
//        testArrayStack();
//        testArrayQueue();
//        testLoopQueue();
        testTimeComplexity();
    }
}
