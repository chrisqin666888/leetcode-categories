package Stack;
import java.util.*;

public class demo {

    public void test(int[] arr) {
        int[] prev_less = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            prev_less[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
    }

    public static void main(String[] args) {
        demo demo = new demo();
        demo.test(new int[]{3, 7, 8, 4});
    }
}
