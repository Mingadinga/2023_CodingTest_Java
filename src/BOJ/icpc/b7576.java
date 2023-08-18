package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.StringTokenizer;

// bfs - 레벨 위주의 탐색
public class b7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Matrix> queue = new ArrayDeque<>();

    static private class Matrix {
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.add(new Matrix(i, j));
            }
        }

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {
            Matrix matrix = queue.pollFirst();
            int x = matrix.x, y = matrix.y, day = map[x][y];

            if (x-1 >= 0 && !visited[x-1][y] && map[x-1][y] == 0) { // 북
                visited[x-1][y] = true;
                map[x-1][y] = day + 1;
                queue.addLast(new Matrix(x-1, y));
            }

            if (y+1 < m && !visited[x][y+1] && map[x][y+1] == 0) { // 동
                visited[x][y+1] = true;
                map[x][y+1] = day + 1;
                queue.addLast(new Matrix(x, y+1));
            }

            if (y-1 >= 0 && !visited[x][y-1] && map[x][y-1] == 0) { // 서
                visited[x][y-1] = true;
                map[x][y-1] = day + 1;
                queue.addLast(new Matrix(x, y-1));
            }

            if (x+1 < n && !visited[x+1][y] && map[x+1][y] == 0) { // 남
                visited[x+1][y] = true;
                map[x+1][y] = day + 1;
                queue.addLast(new Matrix(x+1, y));
            }
        }

        int max = getMax(m, n, map);

        System.out.println(max-1);

    }

    private static int getMax(int m, int n, int[][] map) {
        int max = 0;
        for (int i = 0; i< n; i++) {
            for (int j = 0; j< m; j++) {
                if (map[i][j] == 0) {
                    return 0;
                }
                max = Math.max(max, map[i][j]);
            }
        }
        return max;
    }
}
