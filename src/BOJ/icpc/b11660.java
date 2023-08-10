package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11660 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    static int[][] numbers; static long[][] prefixSum;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        numbers = new int[n+1][n+1];
        prefixSum = new long[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i-1][j] + prefixSum[i][j-1] - prefixSum[i-1][j-1] + numbers[i][j];
            }
        }

        for (int i=0;i<m;i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = input[0];
            int y1 = input[1];
            int x2 = input[2];
            int y2 = input[3];
            sb.append(sum(x1, y1, x2, y2)).append("\n");
        }

        System.out.print(sb);

    }

    private static long sum(int x1, int y1, int x2, int y2) {
        return prefixSum[x2][y2] - prefixSum[x2][y1-1] - prefixSum[x1-1][y2] + prefixSum[x1-1][y1-1];
    }
}
