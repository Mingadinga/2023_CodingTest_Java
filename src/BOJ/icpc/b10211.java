package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10211 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        for (int i=0;i<t;i++) {
            int n = Integer.parseInt(br.readLine());
            int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            sb.append(maxSumOfSubArray(n, numbers)).append("\n");
        }

        System.out.print(sb);
    }

    private static int maxSumOfSubArray(int n, int[] numbers) {

        int[] dp = new int[n];
        dp[0] = numbers[0];

        for (int i=1;i<n;i++) {
            dp[i] = Math.max(numbers[i], dp[i-1]+numbers[i]);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
