package com.company.ch02_stack_and_queue;

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

    public static void testQueueTimeComplexity(){
        int opCount=10000000;

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1=timeDiff(loopQueue,opCount);
        System.out.println("LoopQueue,time: "+time1+" s");

        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        double time3=timeDiff(loopQueue,opCount);
        System.out.println("LinkedQueue,time: "+time3+" s");

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time2=timeDiff(arrayQueue,opCount);
        System.out.println("ArrayQueue,time: "+time2+" s");
    }

    public static void testStackTimeComplexity(){
        int opCount=10000000;

        ArrayStack<Integer> arrayStack= new ArrayStack<>();
        double time1=timeDiff(arrayStack,opCount);
        System.out.println("ArrayStack,time: "+time1+" s");

        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        double time2=timeDiff(linkedStack,opCount);
        System.out.println("LinkedStack,time: "+time2+" s");
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

    public static double timeDiff(Stack<Integer> stack,int opCount){
        long starTime =System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime=System.nanoTime();
        return (endTime-starTime)/1000000000.0;
    }

    public static void testLinkedStack(){
        LinkedStack<Integer> stack = new LinkedStack<>();
        for (int i = 0; i < 6; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }

    public static void main(String[] args) {
//        testArrayStack();
//        testArrayQueue();
//        testLoopQueue();
//        testQueueTimeComplexity();
        testStackTimeComplexity();
//        testLinkedStack();
    }
}
