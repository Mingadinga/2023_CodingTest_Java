package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b15649 {
    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        permutation(n, m, 0, new int[m], new boolean[n]);

        System.out.print(sb);

    }

    private static void permutation(int n, int m, int depth, int[] arr, boolean[] visited) {
        if (depth == m) {
            Arrays.stream(arr).forEach(a -> sb.append(a).append(" "));
            sb.append("\n");
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i]) continue;
            arr[depth] = i+1;
            visited[i] = true;
            permutation(n, m, depth+1, arr, visited);
            visited[i] = false;
        }


    }


}
