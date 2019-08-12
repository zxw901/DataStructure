package com.company.ch10_UnionFind;

public class UnionFind5 implements UF {
    private int[] parent;
    private int[] rank;

    public UnionFind5(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int index) {
        if (index < 0 || index >= parent.length)
            throw new IllegalArgumentException("index is out of bound");
        while (index != parent[index]) {
            parent[index]=parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot)
            return;
        if (rank[pRoot] > rank[qRoot])
            parent[qRoot] = pRoot;
        else if (rank[pRoot] < rank[qRoot])
            parent[pRoot] = qRoot;
        else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
