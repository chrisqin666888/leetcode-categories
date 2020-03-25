package Stack.P1249_Minimum_Remove_To_Make_valie_Parenthesis;

import java.util.Stack;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') stack.push(i);
            if (sb.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else sb.setCharAt(i, '\n');
            }
        }

        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '\n');
        }

        return sb.toString().replaceAll("\\\n", "");
    }
}
