package BOJ.l_Binary_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10815 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[] cards;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        String[] cardArr = br.readLine().split(" ");
        for (int i=0;i<N;i++) {
            cards[i] = Integer.parseInt(cardArr[i]);
        }
        Arrays.sort(cards);

        M = Integer.parseInt(br.readLine());
        String[] targetArr = br.readLine().split(" ");
        for (int i=0;i<M;i++) {
            sb.append(binarySearch(0, N-1, Integer.parseInt(targetArr[i]))).append(" ");
        }
        System.out.println(sb);

    }

    private static int binarySearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (cards[mid] == target) return 1;
            else if (cards[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }

}
