package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10819 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        permutation(numbers, new int[n], n, n, 0, new boolean[n+1]);

        System.out.println(result);
    }

    private static void permutation(int[] numbers, int[] tempArr, int n, int r, int current, boolean[] isSelect) {
        if (current == r) {
            result = Math.max(result, getAbsGap(tempArr));
        }

        for (int i=0;i<n;i++) {
            if(isSelect[i]) continue;

            tempArr[current] = numbers[i];
            isSelect[i] = true;
            permutation(numbers, tempArr, n, r, current+1, isSelect);
            isSelect[i] = false;
        }

    }

    private static int getAbsGap(int[] tempArr) {
        int gap = 0;
        for (int i=0;i<tempArr.length - 1;i++) {
            gap += Math.abs(tempArr[i] - tempArr[i+1]);
        }
        return gap;
    }
}
