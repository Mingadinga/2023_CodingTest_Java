package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1654 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] kn = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = kn[0], n = kn[1];

        long[] lengths = new long[k];
        for (int i=0;i<k;i++) lengths[i] = Long.parseLong(br.readLine());
        Arrays.sort(lengths);

        // 헷갈리면 일단 start, mid, end 다 뽑아서 확인
        long start = 1, end = Arrays.stream(lengths).max().getAsLong(), mid = 0, result = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long countOfBar = getCountOfBar(mid, lengths);
            if (countOfBar < n) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(end);

    }

    private static long getCountOfBar(long length, long[] lengths) {
        long result = 0;
        for (int i=0;i<lengths.length;i++) {
            result += lengths[i] / length;
        }
        return result;
    }
}
