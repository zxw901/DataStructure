package com.company.ch02_stack_and_queue;

import com.company.ch01_Array.Array;

public class ArrayQueue<E> implements Queue<E>{
    Array<E> queue;

    public ArrayQueue(int capacity){
        queue=new Array<>(capacity);
    }
    public ArrayQueue(){
        queue=new Array<>();
    }

    public int getCapacity(){
        return queue.getCapacity();
    }

    @Override
    public int getSize(){
        return queue.getSize();
    }

    @Override
    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public void enqueue(E e){
        queue.addLast(e);
    }

    @Override
    public E dequeue(){
        return queue.removeFirst();
    }

    @Override
    public E getFront(){
        return queue.getFirst();
    }

    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("Queue Capacity:%d front [",getCapacity()));
        for (int i = 0; i < queue.getSize(); i++) {
            sb.append(queue.get(i));
            if (i != queue.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

}
