package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b10828 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) execute(br.readLine().split(" "));
        System.out.println(sb);
    }

    private static void execute(String[] command) {
        char c = command[0].charAt(0);
        if(c == 't') {
            sb.append(stack.isEmpty() ? -1 : stack.lastElement());
        } else if (c == 's') {
            sb.append(stack.size());
        } else if (c == 'e') {
            sb.append(stack.isEmpty() ? 1 : 0);
        } else if (c == 'p') {
            if (command[0].charAt(1) == 'u') {
                stack.push(Integer.parseInt(command[1]));
                return;
            } else if (command[0].charAt(1) == 'o' && !stack.isEmpty()){
                sb.append(stack.pop());
            } else {
                sb.append(-1);
            }
        }
        sb.append("\n");
    }
}
