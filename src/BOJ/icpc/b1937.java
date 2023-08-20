package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1937 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    static int[][] dp;
    static int[][] pos = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 상하좌우
    static int n;

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        dp = new int[n][n];

        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                max = Math.max(max, dfs(i, j));
            }
        }

        System.out.println(max);

    }

    private static int dfs(int x, int y) {

        if (dp[x][y] > 0) return dp[x][y];
        dp[x][y] = 1;

        for (int i=0;i<4;i++) {
            int nx = x+pos[i][0];
            int ny = y+pos[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;

            if (graph[x][y] < graph[nx][ny])
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny)+1);
        }

        return dp[x][y];
    }

}
