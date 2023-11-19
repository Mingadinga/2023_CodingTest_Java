package BOJ.l_Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1789 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        System.out.println(binarySearch(1, s, s));
    }

    static long binarySearch(long start, long end, long target) {
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            if (mid*(mid+1)/2 > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
                answer = mid;
            }
        }
        return answer;
    }
}
