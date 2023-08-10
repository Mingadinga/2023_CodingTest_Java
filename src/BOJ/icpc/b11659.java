package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11659 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    static int[] numbers; static long[] prefixSum;

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        prefixSum = new long[n];

        prefixSum[0] = numbers[0];
        for (int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + numbers[i];
        }

        for (int i=0;i<m;i++) {
            String[] startAndEnd = br.readLine().split(" ");
            int startIndex = Integer.parseInt(startAndEnd[0])-1;
            int endIndex = Integer.parseInt(startAndEnd[1])-1;
            sb.append(sum(startIndex, endIndex)).append("\n");
        }

        System.out.print(sb);

    }

    private static long sum(int startIndex, int endIndex) {
        long suffix = startIndex > 0 ? prefixSum[startIndex-1] : 0;
        return prefixSum[endIndex] - suffix;
    }

}
