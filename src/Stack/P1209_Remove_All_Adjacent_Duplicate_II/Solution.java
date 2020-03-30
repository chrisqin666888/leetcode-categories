package Stack.P1209_Remove_All_Adjacent_Duplicate_II;

import javafx.util.Pair;

import java.util.Stack;

public class Solution {
    public String removeDuplicate(String s, int k) {
        Stack<Pair<Integer, Character>> stack = new Stack<>();
        stack.push(new Pair(0, '#'));

        for (char c : s.toCharArray()) {
            if (stack.peek().getValue() != c) {
                stack.push(new Pair(1, c));
            } else {
                int count = stack.peek().getKey() + 1;
                stack.pop();
                if (count != k) {
                    stack.push(new Pair(count, c));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            for(int i = 0; i < stack.peek().getKey(); i++) {
                sb.append(stack.peek().getValue());
            }
            stack.pop();
        }

        return sb.reverse().toString();
    }
}
