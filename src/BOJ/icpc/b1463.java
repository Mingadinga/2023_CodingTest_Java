package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1463 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[1] = 0;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 1;

        for (int i=4;i<=n;i++) {
            int min = Integer.MAX_VALUE;

            min = Math.min(min, dp[i-1]+1);
            if (i % 3 == 0) min = Math.min(min, dp[i/3]+1);
            if (i % 2 == 0) min = Math.min(min, dp[i/2]+1);

            dp[i] = min;
        }

        System.out.println(dp[n]);

    }
}
