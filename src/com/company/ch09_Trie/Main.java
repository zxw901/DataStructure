package com.company.ch09_Trie;

import com.company.ch06_Set_and_Map.BSTSet;
import com.company.ch06_Set_and_Map.FileOperation;

import java.util.ArrayList;

public class Main {
    public static void testBSTSetTrieSet(){
        ArrayList<String> worlds=new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt",worlds)){
            long startTime=System.nanoTime();

            BSTSet<String> set=new BSTSet<>();
            for (String world : worlds) {
                set.add(world);
            }
            for (String world : worlds) {
                set.contains(world);
            }

            long endTime=System.nanoTime();
            double time=(endTime-startTime)/1000000000.0;
            System.out.println("Total different words: "+set.getSize());
            System.out.println("BSTSet: "+time+" s");


            startTime=System.nanoTime();

            TrieSet trieSet=new TrieSet();
            for (String world : worlds) {
                trieSet.add(world);
            }
            for (String world : worlds) {
                trieSet.contains(world);
            }

            endTime=System.nanoTime();
            time=(endTime-startTime)/1000000000.0;
            System.out.println("Total different words: "+trieSet.getSize());
            System.out.println("BSTSet: "+time+" s");
        }
    }

    public static void main(String[] args) {
        testBSTSetTrieSet();
    }
}
