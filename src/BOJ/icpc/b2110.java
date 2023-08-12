package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2110 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String[] nc = br.readLine().split(" ");
        int n = Integer.parseInt(nc[0]);
        int c = Integer.parseInt(nc[1]);
        int[] positions = new int[n];

        for (int i=0;i<n;i++) {
            positions[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(positions);

        int start = 1, end = positions[n-1], mid = 1, result = 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (countInstallable(mid, positions) < c) end = mid - 1;
            else {start = mid + 1; result = mid; }
        }

        System.out.println(result);

    }

    private static int countInstallable(int distance, int[] positions) {

        int lastInstalled = 0, count = 1;

        for (int i=1;i<positions.length;i++) {
            if (positions[i] - positions[lastInstalled] >= distance) {
                count++; lastInstalled = i;
            }
        }

        return count;
    }

}
