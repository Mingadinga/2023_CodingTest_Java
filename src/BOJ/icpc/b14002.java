package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class b14002 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[n];
        for (int i=0;i<n;i++) dp[i] = 1;

        int maxDP = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (numbers[i] > numbers[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxDP = Math.max(maxDP, dp[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int current = maxDP;
        for (int i=n-1;i>=0;i--) {
            if (dp[i] == current) {
                stack.push(numbers[i]);
                if (--current == 0) break;
            }
        }

        sb.append(maxDP).append("\n");
        while (!stack.isEmpty()) sb.append(stack.pop()).append(" ");

        System.out.print(sb);

    }

}
