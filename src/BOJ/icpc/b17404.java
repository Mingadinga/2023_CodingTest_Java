package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b17404 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int R = 0, G = 1, B = 2, COLORS = 3;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[][] price = new int[n][COLORS];
        int[][] dp = new int[n][COLORS];

        for (int i=0;i<n;i++) {
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0;j<COLORS;j++) {
                price[i][j] = prices[j];
            }
        }

        int minPrice = Integer.MAX_VALUE;

        for (int firstColor = 0;firstColor<COLORS;firstColor++) {
            // 2 번째
            for (int color = 0; color < COLORS; color++) {
                if (color == firstColor) dp[1][color] = Integer.MAX_VALUE;
                else dp[1][color] = price[1][color] + price[0][firstColor];
            }
            // 3 ~ n 번째
            for (int i=2;i<n;i++) {
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + price[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + price[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + price[i][2];
            }
            // dp[n-1]에서 최솟값 구하기. 단 firstColor != color
            for (int color = 0; color < COLORS; color++) {
                if (color == firstColor) continue;
                minPrice = Math.min(minPrice, dp[n-1][color]);
            }

        }

        System.out.println(minPrice);

    }

}
