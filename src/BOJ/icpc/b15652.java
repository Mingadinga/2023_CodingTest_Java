package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b15652 {

    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        combination(n, m, 0, 0, new int[m]);
        System.out.print(sb);
    }

    private static void combination(int n, int r, int index, int depth, int[] arr) {
        if (depth == r) {
            Arrays.stream(arr).forEach(a -> sb.append(a).append(" "));
            sb.append("\n");
            return;
        }

        for (int i=index;i<n;i++) {
            arr[depth] = i+1;
            combination(n, r, i, depth+1, arr);
        }
    }

}
