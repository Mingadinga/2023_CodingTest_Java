package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1929 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        List<Integer> prime = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        for (int i=2;i<=n;i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(i >= m) prime.add(i);
                for (int j=2*i;j<=n;j+=i) {
                    visited[j] = true;
                }
            }
        }

        prime.forEach(p -> sb.append(p).append("\n"));
        System.out.print(sb);

    }
}
