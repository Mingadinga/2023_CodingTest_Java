package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] map;
    static int n;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0;i<n;i++) {
            String line = br.readLine();
            for (int j=0;j<n;j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }

        sb.append(getCountOfGroup()).append("\n");

        Collections.sort(countsOfGroup);
        countsOfGroup.forEach(c -> sb.append(c).append("\n"));
        System.out.print(sb);

    }

    static ArrayList<Integer> countsOfGroup = new ArrayList<>();
    static int tempCount = 0;
    private static int getCountOfGroup() {
        int count = 0;

        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                searchForAllDirection(i, j);
                count++;
                countsOfGroup.add(tempCount);
                tempCount = 0;
            }
        }

        return count;
    }

    private static void searchForAllDirection(int i, int j) {

        if(map[i][j] == 0) return;
        else {map[i][j] = 0; tempCount++;}

        if (i-1 >= 0) searchForAllDirection(i-1, j); // 북
        if (j+1 < n) searchForAllDirection(i, j+1); // 동
        if (j-1 >= 0) searchForAllDirection(i, j-1); // 서
        if (i+1 < n) searchForAllDirection(i+1, j); // 남

    }
}
