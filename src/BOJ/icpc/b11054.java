package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11054 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int nums[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int r_dp[] = new int[n];
        int l_dp[] = new int[n];

        for (int i=0;i<n;i++) {
            r_dp[i] = 1;
            l_dp[i] = 1;
        }

        for (int i=0;i<n;i++) {
            for (int j=0;j<i;j++) {
                if (nums[i] > nums[j]) r_dp[i] = Math.max(r_dp[i], r_dp[j]+1);
            }
        }

        for (int i=n-1;i>=0;i--) {
            for (int j=n-1;j>i;j--) {
                if (nums[i] > nums[j]) l_dp[i] = Math.max(l_dp[i], l_dp[j]+1);
            }
        }

        int max = 0;
        for (int i=0;i<n;i++) {
            max = Math.max(max, r_dp[i]+l_dp[i]-1);
        }
        System.out.println(max);
    }
}
