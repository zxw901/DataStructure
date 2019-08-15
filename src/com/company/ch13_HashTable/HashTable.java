package com.company.ch13_HashTable;

import java.util.TreeMap;

public class HashTable<K, V> {
    private static final int upperTol=10;
    private static final int lowerTol=2;
    private static final int initCapacity=7;
    private int M;
    private int size;
    private TreeMap<K, V>[] hashTable;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initCapacity);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key))
            map.put(key, value);
        else {
            map.put(key, value);
            size++;
        }
        if(size>=upperTol*M){
            resize(2*M);
        }

    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V res = null;
        if (map.containsKey(key)) {
            res = map.remove(key);
            size--;
        }
        if(size<lowerTol*M&&M/2>=initCapacity){
            resize(M/2);
        }
        return res;
    }

    private void resize(int newM){
        TreeMap<K,V>[] newHashTable=new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i]=new TreeMap<>();
        }

        int oldM=M;
        this.M=newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V>map= hashTable[i];
            for (K k : map.keySet()) {
                newHashTable[hash(k)].put(k,map.get(k));
            }
        }

        this.hashTable=newHashTable;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + " doesn't exist!");
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key){
        return hashTable[hash(key)].get(key);
    }
}
