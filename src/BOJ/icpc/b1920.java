package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b1920 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[] numbers = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Arrays.sort(numbers);

        int m = Integer.parseInt(br.readLine());
        long[] targets = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        for (int i=0;i<m;i++) {
            sb.append(binarySearch(numbers, targets[i])).append("\n");
        }
        System.out.print(sb);
    }

    private static int binarySearch(long[] numbers, long target) {
        int start = 0;
        int end = numbers.length - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;

            if (numbers[mid] == target) return 1;
            else if (numbers[mid] < target) {
                start = mid + 1;
            }
            else if (numbers[mid] > target) {
                end = mid - 1;
            }
        }
        return 0;
    }

}
