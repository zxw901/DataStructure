package com.company.ch06_Set_and_Map;

public interface Map<K,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    void set(K key,V value);
    V get(K key);
    boolean isEmpty();
    int getSize();
}
