package com.company.ch06_Set_and_Map;

import java.util.Set;
import java.util.TreeSet;

public class Solution804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] Morse={".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set=new TreeSet<>();
        for (String word : words) {
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(Morse[word.charAt(i)-'a']);
            }
            set.add(sb.toString());
        }

        return set.size();
    }
}
