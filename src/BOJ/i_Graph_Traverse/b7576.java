package BOJ.i_Graph_Traverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 토마토를 기준으로 인접한 칸 하나씩 탐색 -> bfs
// 탐색 : 토마토가 익은데 걸린 날짜 업데이트. 인접한 값이 -1이면 방문하지 않는다
// 탐색 종료 : max 값 출력, 만약 0 있으면 -1 출력
public class b7576 {

    static int n, m;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] nm = br.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);
        int[][] tomatoes = new int[m][n];

        List<Coordinate> ripedTomatoes = new ArrayList<>();
        for (int i=0;i<m;i++) {
            String[] input = br.readLine().split(" ");
            for (int j=0;j<n;j++) {
                tomatoes[i][j] = Integer.parseInt(input[j]);
                if (tomatoes[i][j] == 1) ripedTomatoes.add(new Coordinate(j, i));
            }
        }

        ripeTomatoes(tomatoes, ripedTomatoes);
        System.out.println(getResult(tomatoes));
    }

    private static int getResult(int[][] tomatoes) {
        int max = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (tomatoes[i][j] == 0) return -1;
                max = Math.max(max, tomatoes[i][j]);
            }
        }
        return max-1;
    }

    private static void ripeTomatoes(int[][] tomatoes, List<Coordinate> ripedTomatoes) {

        boolean[][] visited = new boolean[m][n];
        Queue<Coordinate> queue = new LinkedList<>();

        List<Coordinate> directions = List.of(
                new Coordinate(0, 1),
                new Coordinate(0, -1),
                new Coordinate(1, 0),
                new Coordinate(-1, 0)
        );

        for (Coordinate ripedTomato : ripedTomatoes) {
            queue.add(ripedTomato);
            visited[ripedTomato.y][ripedTomato.x] = true;
        }

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            for (Coordinate direction: directions) {
                Coordinate next = current.moveAs(direction);
                if (isValidIndex(next) && !visited[next.y][next.x] && tomatoes[next.y][next.x] != -1) {
                    queue.add(next);
                    visited[next.y][next.x] = true;
                    tomatoes[next.y][next.x] = tomatoes[current.y][current.x] + 1;
                }
            }
        }

    }

    private static boolean isValidIndex(Coordinate next) {
        if (next.x < 0 || next.x >= n) return false;
        if (next.y < 0 || next.y >= m) return false;
        return true;
    }

    static class Coordinate {
        final int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate moveAs(Coordinate direction) {
            return new Coordinate(this.x + direction.x, this.y + direction.y);
        }
    }

}
