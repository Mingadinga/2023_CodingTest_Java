package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b17928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i=0;i<n;i++) {
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                numbers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        Arrays.stream(numbers).forEach(r -> sb.append(r).append(" "));
        System.out.println(sb);
    }
}
