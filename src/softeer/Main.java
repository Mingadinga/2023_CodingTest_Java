package softeer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int lines;
    static int[][] area;
    static boolean[][] visited;
    static List<Coordinate> directionList = new ArrayList<>();
    static List<Integer> answerList = new ArrayList<>();


    public static void main(String[] args) throws Exception {

        lines = Integer.parseInt(br.readLine());

        area = new int[lines][lines];
        for(int i=0; i<lines; i++){
            String[] strings = br.readLine().split(" ");
            for (int j=0;j<strings.length;j++) {
                area[i][j] = Integer.parseInt(strings[j]);
            }
        }

        directionList.add(new Coordinate(-1, 0)); // 왼쪽
        directionList.add(new Coordinate(1, 0)); // 오른쪽
        directionList.add(new Coordinate(0, -1)); // 위쪽
        directionList.add(new Coordinate(0, 1)); // 아래쪽

        visited = new boolean[lines][lines];
        for (int i=0;i<lines;i++) {
            for (int j=0;j<lines;j++) {
                if (area[i][j] == 1 && !visited[i][j]) {
                    answerList.add(bfs(i, j));
                }
            }
        }

        answerList.sort(Comparator.comparingInt(a -> a));
        System.out.println(answerList.size());
        for (Integer answer : answerList) {
            System.out.print(answer);
            System.out.print(" ");
        }


    }

    static private int bfs(int i, int j) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(j, i));
        visited[i][j] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Coordinate base = queue.poll();
            for (Coordinate direction: directionList) {
                Coordinate nextCoordinate = base.moveAs(direction);
                if (isValid(nextCoordinate) && area[nextCoordinate.y][nextCoordinate.x] == 1 && !visited[nextCoordinate.y][nextCoordinate.x]) {
                    queue.add(nextCoordinate);
                    visited[nextCoordinate.y][nextCoordinate.x] = true;
                    count++;
                }
            }
        }

        return count;

    }

    private static boolean isValid(Coordinate nextCoordinate) {
        if (nextCoordinate.x < 0 || nextCoordinate.x >= lines) return false;
        if (nextCoordinate.y < 0 || nextCoordinate.y >= lines) return false;
        return true;
    }

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Coordinate moveAs(Coordinate direction) {
            return new Coordinate(this.x + direction.x, this.y + direction.y);
        }
    }
}