package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b4948 {

    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;
            sb.append(countOfPrimeInRange(n, 2*n)).append("\n");
        }
        System.out.print(sb);
    }

    private static int countOfPrimeInRange(int from, int to) {
        if (to < 2) return 0;
        int count = 0;
        boolean[] visited = new boolean[to+1];

        for (int i=2; i<=to; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(i > from) count++;
                for (int j=i*2;j<=to;j+=i) {
                    visited[j] = true;
                }
            }
        }
        return count;
    }
}
