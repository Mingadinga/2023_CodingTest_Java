package BOJ.a_Data_Structure;

import java.util.*;
import java.io.*;

public class b10828 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        Integer T = Integer.valueOf(br.readLine());
        for (int i=0;i<T;i++) {
            String command[] = br.readLine().split(" ");
            if (command[0].compareTo("push")==0) {
                stack.push(Integer.valueOf(command[1]));
                continue;
            } else if (command[0].compareTo("pop")==0) {
                sb.append(stack.empty() ? -1 : stack.pop());
            } else if (command[0].charAt(0) == 's') {
                sb.append(stack.size());
            } else if (command[0].charAt(0) == 'e') {
                sb.append(stack.empty() ? 1 : 0);
            } else if (command[0].charAt(0) == 't') {
                sb.append(stack.empty() ? -1 : stack.peek());
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
