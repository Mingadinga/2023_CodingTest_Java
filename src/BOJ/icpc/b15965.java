package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b15965 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] prime;

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        prime = new long[k];
        int index = 0;

        boolean[] visited = new boolean[10_000_000];
        for(int i=2;i<10_000_000; i++) {
            if (!visited[i]) {
                visited[i] = true;
                prime[index++] = i;
                if(index == k) break;
                for (int j=2*i;j<10_000_000;j+=i) {
                    visited[j] = true;
                }
            }
        }

        System.out.println(prime[k-1]);
    }
}
