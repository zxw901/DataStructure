package com.company.ch07_Heap_and_PriorityQueue;

import com.company.ch01_Array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data=new Array<>(arr);
        for (int i = parent(arr.length-1); i >=0 ; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子的索引
    private int rightChile(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax(){
        if(data.getSize()==0){
            throw new IllegalArgumentException("Can not findMax when heap is empty");
        }
        return data.get(0);
    }

    public E extractMax(){
        E max=findMax();
        data.swap(0,data.getSize()-1);
        data.removeLast();
        siftDown(0);
        return max;
    }

    private void siftDown(int index) {
        while(leftChild(index)<data.getSize()) {
            int i = leftChild(index);
            if (i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) > 0)
                i = rightChile(index);
            if (data.get(i).compareTo(data.get(index)) <= 0)
                break;

            data.swap(i, index);
            index = i;
        }
    }

    public E replace(E e){
        E res=findMax();
        data.set(0,e);
        siftDown(0);
        return res;
    }

    public void Heapify(){

    }
}
