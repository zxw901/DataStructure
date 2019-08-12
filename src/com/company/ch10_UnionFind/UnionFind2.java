package com.company.ch10_UnionFind;

public class UnionFind2 implements UF{
    private int[] parent;

    public UnionFind2(int size){
        parent=new int[size];

        for (int i = 0; i < size; i++) {
            parent[i]=i;
        }
    }

    private int find(int index){
        if(index<0||index>=parent.length)
            throw new IllegalArgumentException("index is out of bound");
        while(parent[index]!=index){
            index=parent[index];
        }
        return index;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot=find(p);
        int qRoot=find(q);
        if(pRoot==qRoot)
            return;
        parent[pRoot]=qRoot;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
}
