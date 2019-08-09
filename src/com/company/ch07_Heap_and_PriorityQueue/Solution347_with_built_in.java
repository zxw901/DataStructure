package com.company.ch07_Heap_and_PriorityQueue;

import java.util.*;
import java.util.PriorityQueue;

public class Solution347_with_built_in {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a)-map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if(pq.size()<k){
                pq.add(key);
            }else{
                if(map.get(key)>map.get(pq.peek())){
                    pq.remove();
                    pq.add(key);
                }
            }
        }

        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.remove());
        }
        return list;
    }
}
