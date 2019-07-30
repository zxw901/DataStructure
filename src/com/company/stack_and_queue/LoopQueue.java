package com.company.stack_and_queue;

public class LoopQueue<E> implements Queue<E> {
    private E queue[];
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int Capacity) {
        queue = (E[]) new Object[Capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return queue.length - 1;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % queue.length == front) {
            resize(2 * getCapacity());
        }
        queue[tail] = e;
        tail = (tail + 1) % queue.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        E tmp = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;

        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return tmp;
    }

    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("queue is empty");
        }
        return queue[front];
    }

    public void resize(int Capacity) {
        E[] newqueue = (E[]) new Object[Capacity + 1];
        for (int i = 0; i < size; i++) {
            newqueue[i] = queue[(i + front) % queue.length];
        }
        queue = newqueue;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(String.format("LoopQueue:Size:%d,Capacity:%d\nfront [", getSize(), getCapacity()));
        for (int i = front; i != tail; i = (i + 1) % queue.length) {
            sb.append(queue[i]);

            if (i != tail - 1) {
                sb.append(',');
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
