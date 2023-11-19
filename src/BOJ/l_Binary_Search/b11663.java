package BOJ.l_Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b11663 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static long[] points;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        String[] pointArr = br.readLine().split(" ");
        points = new long[N];
        for (int i=0;i<N;i++) {
            points[i] = Long.parseLong(pointArr[i]);
        }
        Arrays.sort(points);

        for (int i=0;i<M;i++) {
            String[] scope = br.readLine().split(" ");
            int result = binarySearchCount(Integer.parseInt(scope[0]), Integer.parseInt(scope[1]));
            sb.append(result).append("\n");
        }

        System.out.print(sb);
    }

    private static int binarySearchCount(int start, int end) {
        return binarySearchAsEnd(end) - binarySearchAsStart(start) + 1;
    }

    private static int binarySearchAsEnd(int target) {
        int start = 0, end = N-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (points[mid] == target) return mid;
            else if (points[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return end;
    }

    private static int binarySearchAsStart(int target) {
        int start = 0, end = N-1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (points[mid] == target) return mid;
            else if (points[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return start;
    }

    private static int getIndexInScope(int start) {
        if (start < 0) return 0;
        else if (start > N-1) return N-1;
        return start;
    }
}
