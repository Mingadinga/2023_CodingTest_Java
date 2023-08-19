package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

public class b7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static int[][] graphValue;
    static boolean[][] visited;
    static int[][] pos = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    static int n;

    static class Matrix {
        int x, y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Matrix matrix = (Matrix) o;
            return x == matrix.x && y == matrix.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i=0;i<t;i++) {
            n = Integer.parseInt(br.readLine());

            graph = new int[n][n];
            graphValue = new int[n][n];
            visited = new boolean[n][n];

            st = new StringTokenizer(br.readLine());
            int curX = Integer.parseInt(st.nextToken());
            int curY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int finX = Integer.parseInt(st.nextToken());
            int finY = Integer.parseInt(st.nextToken());

            bfs(curX, curY);
            sb.append(graphValue[finX][finY]).append("\n");
        }

        System.out.print(sb);

    }

    private static void bfs(int x, int y) {

        Deque<Matrix> queue = new ArrayDeque<>();
        queue.addLast(new Matrix(x, y)); visited[x][y] = true;

        while (!queue.isEmpty()) {
            Matrix head = queue.pollFirst();

            for(int i=0; i<pos.length; i++) {
                int nX = head.x + pos[i][0];
                int nY = head.y + pos[i][1];

                if(nX < 0 || nX >= n || nY < 0 || nY >= n || visited[nX][nY] || graph[nX][nY] != 0) {
                    continue;
                }

                visited[nX][nY] = true;
                graphValue[nX][nY] = graphValue[head.x][head.y] + 1;
                queue.addLast(new Matrix(nX, nY));
            }

        }


    }
}
