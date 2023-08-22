package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b4179 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map;
    static int[][] visitedFire;
    static int[][] visitedJihoon;
    static int r, c;
    static int[][] pos = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}}; // 상하좌우

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visitedFire = new int[r][c];
        visitedJihoon = new int[r][c];

        int jhX=0, jhY=0, fireX=0, fireY=0;
        for (int i=0;i<r;i++) {
            String input = br.readLine();
            for (int j=0;j<c;j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'J') {
                    jhX = j; jhY = i;
                }
                if (map[i][j] == 'F') {
                    fireX = j; fireY = i;
                }
            }
        }

        bfsFire();
        int result = bfsJihoon(jhX, jhY);

        if (result == -1) System.out.println("IMPOSSIBLE");
        else System.out.println(result);

    }

    private static int bfsJihoon(int jhX, int jhY) {

        Deque<Matrix> queue = new ArrayDeque<>();
        queue.addLast(new Matrix(jhX, jhY));
        visitedJihoon[jhY][jhX] = 1;

        while (!queue.isEmpty()) {
            Matrix cur = queue.pollFirst();

            for (int i=0;i<4;i++) {
                int nextX = cur.x+pos[i][0];
                int nextY = cur.y+pos[i][1];

                if (nextX < 0 || nextY < 0 || nextX >= c || nextY >= r) {
                    return visitedJihoon[cur.y][cur.x];
                }

                if (map[nextY][nextX] == '#' || visitedJihoon[nextY][nextX] != 0 ) continue;
                if ((visitedJihoon[cur.y][cur.x]+1 >= visitedFire[nextY][nextX]) && visitedFire[nextY][nextX] != 0) continue;

                queue.addLast(new Matrix(nextX, nextY));
                visitedJihoon[nextY][nextX] = visitedJihoon[cur.y][cur.x]+1;
            }

        }

        return -1;
    }

    private static void bfsFire() {

        Deque<Matrix> queue = new ArrayDeque<>();

        for (int i=0;i<r;i++) {
            for (int j=0;j<c;j++) {
                if (map[i][j] == 'F') {
                    queue.addLast(new Matrix(j, i));
                    visitedFire[i][j] = 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            Matrix cur = queue.pollFirst();

            for (int i=0;i<4;i++) {
                int nextX = cur.x+pos[i][0];
                int nextY = cur.y+pos[i][1];
                if (nextX < 0 || nextY < 0 || nextX>=c || nextY >= r) continue;
                if (map[nextY][nextX] == '#' || visitedFire[nextY][nextX] != 0) continue;
                queue.addLast(new Matrix(nextX, nextY));
                visitedFire[nextY][nextX] = visitedFire[cur.y][cur.x]+1;
            }

        }
    }

    private static class Matrix {
        int x, y;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
