package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b23327 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] NQ = br.readLine().split(" ");
        int N = Integer.parseInt(NQ[0]);
        int Q = Integer.parseInt(NQ[1]);

        long[] fun = new long[N+1];
        long[] funSum = new long[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            fun[i] = Integer.parseInt(st.nextToken());
            funSum[i] = funSum[i-1] + fun[i];
        }

        long[] total = new long[N+1];
        for (int i=1;i<=N;i++) total[i] = total[i-1] + fun[i] * funSum[i-1];

        for (int i=0;i<Q;i++) {
            String[] lr = br.readLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            int r = Integer.parseInt(lr[1]);
            if (l == 1) sb.append(total[r]).append("\n");
            else sb.append(total[r] - total[l-1] - (funSum[l-1] * (funSum[r] - funSum[l-1]))).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb);

    }

}
