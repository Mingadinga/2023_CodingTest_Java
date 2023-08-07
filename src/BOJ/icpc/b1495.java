package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1495 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);

        int[] gaps = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 곡 : 0~N-1
        // 볼륨 : 0~M
        boolean dp[][] = new boolean[N][M+1];

        if (S + gaps[0] <= M) dp[0][S + gaps[0]] = true;
        if (S - gaps[0] >= 0) dp[0][S - gaps[0]] = true;

        for (int i=1;i<N;i++) {
            for (int j=0;j<=M;j++) {
                if (dp[i-1][j]) {
                    if (j + gaps[i] <= M) dp[i][j + gaps[i]] = true;
                    if (j - gaps[i] >= 0) dp[i][j - gaps[i]] = true;
                }
            }
        }

        int max = -1;
        for (int i=0;i<=M;i++) {
            if (dp[N-1][i]) max = Math.max(max, i);
        }
        System.out.println(max);
    }
}
