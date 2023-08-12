package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b21758 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] sum = new long[N];

        sum[0] = arr[0];
        for (int i=1;i<N;i++) {
            sum[i] = sum[i-1] + arr[i];
        }

        long max = 0;
        max = Math.max(max, honeyCombAtLeft(arr, sum));
        max = Math.max(max, honeyCombAtRight(arr, sum));
        max = Math.max(max, honeyCombMove(arr, sum));

        System.out.println(max);
    }

    private static long honeyCombAtLeft(long[] arr, long[] sum) {
        long max = 0; int fixedBaseIndex = arr.length - 1;

        for (int i=1;i<fixedBaseIndex;i++) {
            long leftMove = sum[i-1];
            long rightFix = sum[fixedBaseIndex] - arr[fixedBaseIndex] - arr[i];
            max = Math.max(max, leftMove + rightFix);
        }

        return max;
    }

    private static long honeyCombAtRight(long[] arr, long[] sum) {
        long max = 0; int honeyCombIndex = arr.length - 1;

        for (int i=1;i<honeyCombIndex;i++) {
            long leftFix = sum[honeyCombIndex] - arr[0] - arr[i];
            long rightMove = sum[honeyCombIndex] - sum[i];
            max = Math.max(max, leftFix + rightMove);
        }

        return max;
    }

    private static long honeyCombMove(long[] arr, long[] sum) {
        long max = 0; int leftFixIndex = 0, rightFixIndex = arr.length - 1;

        for (int i=1;i<rightFixIndex;i++) {
            long leftOfHoneyComb = sum[i] - arr[leftFixIndex];
            long rightOfHoneyComb = sum[rightFixIndex - 1] - sum[i - 1];
            max = Math.max(max, leftOfHoneyComb + rightOfHoneyComb);
        }

        return max;
    }

}

