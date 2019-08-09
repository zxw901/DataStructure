package com.company.ch08_SegmentTree;

public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merge<E> merge;

    public SegmentTree(E[] arr,Merge<E> merge){
        this.merge=merge;
        data=(E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i]=arr[i];
        }

        tree=(E[])new Object[4*arr.length];
        buildSegmentTree(0,0,arr.length-1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }
        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex]=merge.merge(tree[leftTreeIndex],tree[rightTreeIndex]);
    }


    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>=data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    //两个辅助函数
    private int leftChild(int index){
        return index*2+1;
    }

    private int rightChild(int index){
        return index*2+2;
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if(tree[i]!=null)
                res.append(tree[i]);
            else
                res.append("null");
            if(i!=tree.length-1)
                res.append(',');
        }
        res.append(']');
        return res.toString();
    }
}
