package BOJ.e_dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// dp[i] : 정수 i를 1로 만드는 연산 횟수의 최솟값. 단 1 <= i <= 10^6
// 초기화 : dp[1] = 0, dp[2] = 1, dp[3] = 2
// 그후 계산 : dp[4] = 2, dp[5] = 3, dp[6] = 2
public class b1463 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        dp[1] = 0;
        if (n >= 2) dp[2] = 1;
        if (n >= 3) dp[3] = 1;

        for (int i=4;i<=n;i++) {
            int min = Integer.MAX_VALUE;

            min = Math.min(min, 1+dp[i-1]);
            if (i % 3 == 0) min = Math.min(min, 1+dp[i/3]);
            if (i % 2 == 0) min = Math.min(min, 1+dp[i/2]);

            dp[i] = min;
        }

        System.out.println(dp[n]);
    }
}
