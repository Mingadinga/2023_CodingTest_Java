package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10026 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static char[][] map;
    static int n;


    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i=0;i<n;i++) {
            String line = br.readLine();
            for (int j=0;j<n;j++) {
                map[i][j] = line.charAt(j);
            }
        }

        sb.append(countGroupOfNormal()).append(" ").append(countGroupOfColorBlind());
        System.out.println(sb);

    }

    private static int countGroupOfNormal() {
        int count = 0;
        boolean[][] visited = new boolean[n][n];

        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (visited[i][j]) continue;
                dfs(i, j, map[i][j], visited);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int i, int j, char color, boolean[][] visited) {

        if (visited[i][j] || map[i][j] != color) return;
        else visited[i][j] = true;

        if (i-1 >= 0) dfs(i-1, j, color, visited); // 북
        if (j+1 < n) dfs(i, j+1, color, visited); // 동
        if (j-1 >= 0) dfs(i, j-1, color, visited); // 서
        if (i+1 < n) dfs(i+1, j, color, visited); // 남

    }

    private static int countGroupOfColorBlind() {
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                if (map[i][j] == 'R') map[i][j] = 'G';
            }
        }

        return countGroupOfNormal();
    }
}
