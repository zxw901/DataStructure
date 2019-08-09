package com.company.ch07_Heap_and_PriorityQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Solution347 {
    private class Freq implements Comparable<Freq>{
        public int e,freq;

        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }

        @Override
        public int compareTo(Freq other) {
            if(this.freq>other.freq)
                return -1;
            if(this.freq<other.freq)
                return 1;
            return 0;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for (int num : nums) {
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        PriorityQueue<Freq> pq =new PriorityQueue<>();
        for (Integer key : map.keySet()) {
            if(pq.getSize()<k){
                pq.enqueue(new Freq(key,map.get(key)));
            }else{
                if(map.get(key)>pq.getFront().freq){
                    pq.dequeue();
                    pq.enqueue(new Freq(key,map.get(key)));
                }
            }
        }

        List<Integer> list=new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.dequeue().e);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] a={1,1,1,2,2,3};
        System.out.println((new Solution347()).topKFrequent(a,2));
    }
}
