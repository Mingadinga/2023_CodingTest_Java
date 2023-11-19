package BOJ.n_Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class b17829 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] area;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];

        for (int i=0;i<N;i++) {
            String[] ints = br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                area[i][j] = Integer.parseInt(ints[j]);
            }
        }

        int result = pooling222(N, 0, 0);
        System.out.println(result);
    }

    private static int pooling222(int size, int row, int col) {
        // 종료 조건 : size가 2이면 두번째로 작은 원소 반환
        if (size <= 2) {
            List<Integer> temp = new ArrayList<>();
            for (int i=row;i<row+size;i++) {
                for (int j=col;j<col+size;j++) {
                    temp.add(area[i][j]);
                }
            }
            temp.sort(Comparator.comparingInt(o -> o));
            return temp.get(2);
        }

        // size가 2보다 크다면 사분할로 쪼개기
        int nextSize = size / 2;
        int p1 = pooling222(nextSize, row, col);
        int p2 = pooling222(nextSize, row, col+nextSize);
        int p3 = pooling222(nextSize, row+nextSize, col);
        int p4 = pooling222(nextSize, row+nextSize, col+nextSize);

        // 합치기 : 각 사분할에서 풀링한 수에 대해 다시 풀링
        List<Integer> temp = Arrays.asList(p1, p2, p3, p4);
        temp.sort(Comparator.comparingInt(o -> o));
        return temp.get(2);
    }

}
