package com.company.ch10_UnionFind;

public interface UF {
    int getSize();
    void unionElements(int p,int q);
    boolean isConnected(int p,int q);
}
