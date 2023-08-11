package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b15810 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];
        int[] minutes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(minutes);

        // 최솟값은 범위가 커질 때 업데이트함
        long start = 0, end = (long) m * Arrays.stream(minutes).max().getAsInt(), result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (countBalloonsAbleToMake(mid, minutes) >= m) {
                end = mid-1;
            } else {
                start = mid+1;
                result = start;
            }
        }

        System.out.println(result);

    }

    public static long countBalloonsAbleToMake(long totalMinute, int[] minutes) {
        long result = 0;
        for (int i=0;i<minutes.length;i++) {
            result += totalMinute / minutes[i];
        }
        return result;
    }

}
