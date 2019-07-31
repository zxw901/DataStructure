package com.company.ch02_stack_and_queue;

public class LinkedQueue<E> implements Queue<E> {
    private class Node {
        E e;
        Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node del = head;
        head = head.next;
        del.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return del.e;
    }

    @Override
    public E getFront(){
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("Queue: front");
        Node cur=head;
        while(cur!=null){
            sb.append(cur+"->");
            cur=cur.next;
        }
        sb.append("NULL tail");
        return sb.toString();
    }
}
