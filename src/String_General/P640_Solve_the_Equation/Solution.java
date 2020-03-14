package String_General.P640_Solve_the_Equation;

public class Solution {
    public String solveEquations(String equation) {
        String[] parts = equation.split("=");
        int[] left = evaluate(parts[0]);
        int[] right = evaluate(parts[1]);

        if (left[0] == right[0] && left[1] == right[1]) {
            return "Infinite Solutions";
        } else if (left[0] == right[0]) {
            return "No Solution";
        }

        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    private int[] evaluate(String str) {
        String[] tokens = str.split("(?=[+-])");
        int[] res = new int[2];

        for(String token : tokens) {
            if (token.equals("+x") || token.equals("x")) {
                res[0]++;
            } else if (token.equals("-x")){
                res[0]--;
            } else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.length() - 1));
            } else {
                res[1] = Integer.parseInt(token);
            }
        }

        return res;
    }
}
