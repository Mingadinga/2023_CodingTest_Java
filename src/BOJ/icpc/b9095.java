package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9095 {

    static BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
    static StringBuilder sb = new StringBuilder();
    static int[] counts = new int[11];

    public static void main(String[] args) throws IOException {
        counts[0] = 1;
        counts[1] = 1;
        counts[2] = 2;

        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            sb.append(getCountOfCases(Integer.parseInt(br.readLine()))).append("\n");
        }
        System.out.print(sb);

    }

    // counts[n] = counts[n-3]+counts[n-2]+counts[n-1]
    private static int getCountOfCases(int target) {

        for (int i=3;i<=target;i++) {
            counts[i] = counts[i-3]+counts[i-2]+counts[i-1];
        }

        return counts[target];

    }
}
