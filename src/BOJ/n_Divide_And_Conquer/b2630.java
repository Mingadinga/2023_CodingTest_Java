package BOJ.n_Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2630 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] area;
    static int white, blue;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<N; j++) {
                area[i][j] = arr[j];
            }
        }

        findColoredPaperCount(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void findColoredPaperCount(int row, int col, int size) {
        // 문제 해결 : 분할된 영역의 색이 모두 같음
        int color = area[row][col];
        boolean isAllSameColor = true;
        for (int i=row;i<row+size && isAllSameColor;i++) {
            for (int j=col;j<col+size;j++) {
                if (area[i][j] != color) {
                    isAllSameColor = false;
                    break;
                }
            }
        }

        // 합치기 : 전역 변수 count 증가 처리
        if (isAllSameColor) {
            if (color == 0) white++;
            else if (color == 1) blue++;
            return;
        }

        // 쪼개기 : 1, 2, 3, 4사분면에 대해서 재귀
        int nextSize = size / 2;
        findColoredPaperCount(row, col, nextSize);
        findColoredPaperCount(row, col + nextSize, nextSize);
        findColoredPaperCount(row + nextSize, col, nextSize);
        findColoredPaperCount(row + nextSize, col + nextSize, nextSize);


    }


}
