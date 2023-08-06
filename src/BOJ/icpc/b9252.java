package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class b9252 {
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        char[] str1 = br.readLine().toCharArray();
        char[] str2 = br.readLine().toCharArray();

        int n1 = str1.length;
        int n2 = str2.length;

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int current = dp[str1.length][str2.length];
        Stack<Character> stack = new Stack<>();
        for (int i=n1;i>0;i--) {
            for (int j=n2;j>0;j--) {
                if (current == dp[i][j]
                        && str1[i-1] == str2[j-1]) {
//                    System.out.printf("%d %c i=%d j=%d\n", current, str1[i-1], i, j);
                    stack.push(str1[i-1]);
                    current--;
                    break;
                }
            }
        }

        sb.append(dp[str1.length][str2.length]).append("\n");
        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.print(sb);

    }
}
