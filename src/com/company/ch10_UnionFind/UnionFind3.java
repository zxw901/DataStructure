package com.company.ch10_UnionFind;

public class UnionFind3 implements UF {
    private int[] parent;
    private int[] size;

    public UnionFind3(int size) {
        parent = new int[size];
        this.size = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            this.size[i] = 1;
        }
    }

    private int find(int index) {
        if (index < 0 || index >= parent.length)
            throw new IllegalArgumentException("index is out of bound");
        while (index != parent[index]) {
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
        if (size[pRoot] > size[qRoot]) {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
