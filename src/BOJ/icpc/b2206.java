package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b2206 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
//    static int[][] graphValue;
    static int[][][] visited;
    static int[][] pos = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}}; // 상우하좌
    static int n, m;

    static class Item {
        int x, y;
        int crashed;
        int count;

        public Item(int x, int y, int crashed, int count) {
            this.x = x;
            this.y = y;
            this.crashed = crashed;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n+1][m+1];
        visited = new int[n+1][m+1][2];

        for (int i=1;i<n+1;i++) {
            String line = br.readLine();
            for (int j=1;j<m+1;j++) {
                graph[i][j] = line.charAt(j-1)-'0';
            }
        }

        for (int i=0;i<n+1;i++) graph[i][0] = -1;
        for (int i=0;i<m+1;i++) graph[0][i] = -1;


        bfs();

    }

    public static void bfs() {

        Deque<Item> queue = new ArrayDeque<>();
        queue.addLast(new Item(1, 1, 0, 1));
        visited[1][1][0] = 1;

        while (!queue.isEmpty()) {
            Item item = queue.pollFirst();
            int curX = item.x;
            int curY = item.y;
            int curCrashed = item.crashed;
            int curCount = item.count;

            if (curX == m && curY == n) {
                System.out.println(visited[curX][curY][curCrashed]);
                return;
            }

            for (int i=0;i<4;i++) {
                int nextX = curX+pos[i][0];
                int nextY = curY+pos[i][1];

                // 유효성 검사
                if (nextX < 1 || nextX > m || nextY < 1 || nextY > n) continue;

                // 0이면 이동
                if (graph[nextY][nextX] == 0 && visited[nextY][nextX][curCrashed] == 0) {

                    if (nextX == m && nextY == n) {
                        System.out.println(curCount+1);
                        return;
                    }

                    visited[nextY][nextX][curCrashed]++;
                    queue.addLast(new Item(nextX, nextY, curCrashed, curCount+1));
                }

                // 벽 부심
                if (graph[nextY][nextX] == 1 && curCrashed == 0) {
                    visited[nextY][nextX][curCrashed+1] = visited[curY][curX][curCrashed] + 1;
                    queue.addLast(new Item(nextX, nextY, 1, curCount+1));
                }

            }

        }

        System.out.println(-1);
    }

}
