package com.company.ch09_Trie;

import com.company.ch06_Set_and_Map.Set;

public class TrieSet implements Set<String> {

    private Trie trie;

    public TrieSet(){
        trie=new Trie();
    }

    @Override
    public void add(String world) {
        trie.add(world);
    }


    //暂时没空实现
    @Override
    public void remove(String s) {

    }

    @Override
    public boolean contains(String world) {
        return trie.contains(world);
    }

    @Override
    public int getSize() {
        return trie.getSize();
    }

    @Override
    public boolean isEmpty() {
        return trie.isEmpty();
    }
}
