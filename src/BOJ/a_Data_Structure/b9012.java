package BOJ.a_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            String ps = br.readLine();
            boolean isRight = checkParenthesis(sb, stack, ps);
            if (!isRight) sb.append("NO\n");
            else if (stack.empty()) sb.append("YES\n");
            else sb.append("NO\n");
            stack.clear();
        }
        System.out.print(sb);
    }

    private static boolean checkParenthesis(StringBuilder sb, Stack<Character> stack, String ps) {
        for (int j = 0; j< ps.length(); j++) {
            Character token = ps.charAt(j);
            if (token == '(') stack.push('(');
            else if (token == ')') {
                if (stack.empty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }

}
