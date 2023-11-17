package BOJ.e_dp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 둘다 공백 : *3
// 왼쪽 오른쪽만 있음 : *2
// dp[1] : 1 1 1 -> 3
// dp[2] : 3 2 2 -> 7
// dp[3] : 7 5 5 -> 17
// dp[4] : 21 10 10 -> 41
// dp[i] = dp[i-2] + 2 * dp[i-1]
public class b1309 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 3;
        if (n >= 2) dp[2] = 7;

        for (int i=3;i<=n;i++) {
            dp[i] = (2 * dp[i-1] + dp[i-2]) % 9901;
        }

        System.out.println(dp[n]);
    }

}
