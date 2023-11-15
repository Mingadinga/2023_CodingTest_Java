package BOJ.j_Implemntation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class b2615 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] table;

    public static void main(String[] args) throws IOException {

        // 바둑판 상태 입력
        table = new int[19][19];
        List<Coordinate> black = new ArrayList<>();
        List<Coordinate> white = new ArrayList<>();

        for (int i=0;i<19;i++) {
            String[] splitString = br.readLine().split(" ");
            for (int j=0;j<19;j++) {
                table[i][j] = Integer.parseInt(splitString[j]);
                if (table[i][j] == 1) black.add(new Coordinate(j, i));
                else if (table[i][j] == 2) white.add(new Coordinate(j, i));
            }
        }

        // 탐색 방향 설정
        List<Coordinate> directions = new ArrayList<>();
        directions.add(new Coordinate(1, -1)); // 우상향
        directions.add(new Coordinate(1, 0)); // 오른쪽
        directions.add(new Coordinate(1, 1)); // 우하향
        directions.add(new Coordinate(0, 1)); // 아래쪽

        // 흑돌 확인
        Coordinate blackResult = null;
        for (Coordinate start: black) {
            // 인접 방향 중 이동할 방향 선택
            List<Coordinate> nextDirections = new ArrayList<>();
            for (Coordinate direction: directions) {
                // 범위가 유효하고 흑돌이면 탐색할 방향으로 선택
                Coordinate nextCoordinate = start.moveAs(direction);
                if (isValid(nextCoordinate) && table[nextCoordinate.y][nextCoordinate.x] == 1) nextDirections.add(direction);
            }
            // 선택된 방향에서 연속 다섯 알이 있는지 확인
            blackResult = checkSuccessCase(start, nextDirections, 1);
            if (blackResult != null) {
                System.out.println(1);
                System.out.println((blackResult.y+1)+" "+(blackResult.x+1));
                return;
            }
        }

        // 백돌 확인
        Coordinate whiteResult = null;
        for (Coordinate start: white) {
            // 인접 방향 중 이동할 방향 선택
            List<Coordinate> nextDirections = new ArrayList<>();
            for (Coordinate direction: directions) {
                // 범위가 유효하고 흑돌이면 탐색할 방향으로 선택
                Coordinate nextCoordinate = start.moveAs(direction);
                if (isValid(nextCoordinate) && table[nextCoordinate.y][nextCoordinate.x] == 2) nextDirections.add(direction);
            }
            // 선택된 방향에서 연속 다섯 알이 있는지 확인
            whiteResult = checkSuccessCase(start, nextDirections, 2);
            if (whiteResult != null) {
                System.out.println(2);
                System.out.println((whiteResult.y+1)+" "+(whiteResult.x+1));
                return;
            }
        }

        // 무승부
        System.out.println(0);

    }

    private static Coordinate checkSuccessCase(Coordinate start, List<Coordinate> nextDirections, int color) {
        // 시작점을 기준으로 각 방향에 대해 오목 있는지 확인
        for (Coordinate direction: nextDirections) {
            // 스택 추가 조건 : 스택 top에서 이동시킨 좌표가 유효하고 값이 color이면
            // 탐색 종료 조건 : 6목 판단을 위해 연속된 color을 6개까지 읽기
            Stack<Coordinate> stack = new Stack<>();
            stack.add(start);
            boolean mayBeSuccess = false; // 정답 후보
            while(stack.size() <= 5) {
                Coordinate movedCoordinate = stack.peek().moveAs(direction);
                if (!isValid(movedCoordinate)) break;
                if (table[movedCoordinate.y][movedCoordinate.x] != color) break;
                stack.add(movedCoordinate);
                if (stack.size() == 5) mayBeSuccess = true;
                else if (stack.size() > 5) mayBeSuccess = false;
            }

            if (mayBeSuccess) {
                // 정답 후보이더라도 6목 이상이라면 정답이 아님
                if ((start.y-direction.y >= 0 && start.y-direction.y < 19) && (start.x-direction.x >= 0 && start.x-direction.x < 19)) {
                    if (table[start.y-direction.y][start.x-direction.x] != color) return start;
                } else return start;
            }

        }
        return null;
    }

    private static boolean isValid(Coordinate coordinate) {
        if (coordinate.x < 0 || coordinate.x >= 19) return false;
        if (coordinate.y < 0 || coordinate.y >= 19) return false;
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
