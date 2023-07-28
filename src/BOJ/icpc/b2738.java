package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2738 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        final int n = Integer.parseInt(input[0]);
        final int m = Integer.parseInt(input[1]);

        int[][] a = new int[n][m];

        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++) a[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0;j<m;j++) a[i][j] += Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                sb.append(a[i][j]);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }

        System.out.print(sb);

    }
}
