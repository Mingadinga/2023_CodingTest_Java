package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class b23057 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Set<Integer> set = new HashSet<>();
    static int[] card;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        card = new int[n];
        int sum = 0;

        for (int i=0;i<n;i++) {
            card[i] = Integer.parseInt(st.nextToken());
            sum += card[i];
        }

        // 모든 조합에 대해 sum 계산해서 set에 추가하기
        for (int i=1;i<=sum;i++) {
            combination(n, i, new int[n], sum, 0, 0);
        }

        System.out.println(sum - set.size());

    }

    static void combination(int n, int r, int[] arr, int sum, int index, int depth) {

        if (depth == r) {
            set.add(Arrays.stream(arr).filter(a -> a > 0).map(a -> card[a-1]).sum());
            return;
        }

        for (int i=index;i<n;i++) {
            arr[depth] = i+1;
            combination(n, r, arr, sum, i+1, depth+1);
        }

    }

}
