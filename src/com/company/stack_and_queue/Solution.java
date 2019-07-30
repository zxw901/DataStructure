package com.company.stack_and_queue;

public class Solution {
    public boolean isValid(String s) {
        ArrayStack<Character> stack =new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (top == '(' && c != ')')
                    return false;
                if (top == '[' && c != ']')
                    return false;
                if (top == '{' && c != '}')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).isValid("[({(())}[()])]"));
    }
}
