package com.company;

import com.company.Array.Array;

public class Main {

    public static void main(String[] args) {
        Array arr=new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.addIndex(4,100);
        System.out.println(arr);
        arr.addFist(60);
        System.out.println(arr);
    }
}
