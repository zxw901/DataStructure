package com.company.ch06_Set_and_Map;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set=new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int value : nums2) {
            if (set.contains(value)) {
                arrayList.add(value);
                set.remove(value);
            }
        }

        int[] res=new int[arrayList.size()];
        for (int i = 0; i <arrayList.size() ; i++) {
            res[i]=arrayList.get(i);
        }
        return res;
    }
}
