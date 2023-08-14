package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1253 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        if (n <= 2) {
            System.out.println(0); return;
        }

        int count = 0;

        for(int i=0;i<n;i++) {
            long target = arr[i]; int start = 0, end = n-1;

            while (true) {
                if (start == i) start++;
                if (end == i) end--;
                if (start >= end) break;
                long sum = arr[start] + arr[end];
                if (sum == target) {
                    count++; break;
                }
                else if (sum > target) end--;
                else start++;
            }
        }

        System.out.println(count);

    }

}
