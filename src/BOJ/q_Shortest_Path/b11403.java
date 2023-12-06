package BOJ.q_Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11403 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, INF;
    static int[][] adjacentArray;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        INF = N+1;
        adjacentArray = new int[N][N];

        for (int i=0;i<N;i++) {
            String[] s = br.readLine().split(" ");
            for (int j=0;j<N;j++) {
                int parseInt = Integer.parseInt(s[j]);
                if (parseInt == 0) parseInt = INF;
                adjacentArray[i][j] = parseInt;
            }
        }

        floydWarshall();
        printResult();

    }

    private static void floydWarshall() {
        for (int m = 0; m < N; m++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    adjacentArray[i][j] = Math.min(adjacentArray[i][j], adjacentArray[i][m]+adjacentArray[m][j]);
                }
            }
        }
    }

    private static void printResult() {
        StringBuilder sb = new StringBuilder();

        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                int num = adjacentArray[i][j];
                if (num >= INF || num < 0) num = 0;
                else num = 1;
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

    }

}
