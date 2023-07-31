package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class b9020 {

    // 입력받은 수 중 가장 큰 수보다 작은 모든 소수 구하기
    // 가장 큰 수 사이즈의 boolean[]에 소수 여부 저장
    // 중간값과 가장 가까운 소수 찾고, 차이가 소수인지 확인

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static boolean[] isPrime;
    private static int[] testcases;

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        testcases = new int[n];

        int max = 0;
        for (int i=0;i<n;i++) {
            int t = Integer.parseInt(br.readLine());
            testcases[i] = t;
            max = Math.max(max, t);
        }

        isPrime = new boolean[max+1];
        initPrimeInRange(max);
        for (int i=0;i<n;i++) checkGoldBach(testcases[i]);
        System.out.print(sb);
    }

    private static void initPrimeInRange(int to) {
        boolean[] visited = new boolean[to+1];
        for (int i=2; i<=to; i++) {
            if(!visited[i]) {
                visited[i] = true;
                isPrime[i] = true;
                for (int j=i*2;j<=to;j+=i) {
                    visited[j] = true;
                }
            }
        }
    }

    private static void checkGoldBach(int testcase) {

        int half = testcase / 2;

        for (int i=half;i<=testcase;i++) {
            if(isPrime[i] && isPrime[testcase - i]) {
                sb.append(String.format("%d %d\n", testcase - i, i));
                break;
            }
        }

    }


}
