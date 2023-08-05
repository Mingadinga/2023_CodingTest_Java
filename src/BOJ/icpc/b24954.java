package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class b24954 {

    static int minAmount = Integer.MAX_VALUE;
    static int[] price;
    static HashMap<Integer, ArrayList<DiscountInfo>> discountInfo;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        price = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        discountInfo = new HashMap<>();

        for (int i=0;i<N;i++) {
            int p = Integer.parseInt(br.readLine());
            ArrayList<DiscountInfo> temp = new ArrayList<>();
            for (int j=0;j<p;j++) {
                String[] input = br.readLine().split(" ");
                temp.add(new DiscountInfo(Integer.parseInt(input[0])-1, Integer.parseInt(input[1])));
            }
            discountInfo.put(i, temp);
        }

        calculateMinPriceToGetAll(N, 0, new int[N], new boolean[N+1]);
        System.out.println(minAmount);

    }

    // 순열에 대해서 종료조건에 대해 amount 계산, 최소 비용만 기록
    private static void calculateMinPriceToGetAll(int n, int depth, int[] sequence, boolean[] visited) {
        if(depth == n) {
            minAmount = Math.min(minAmount, calculatePrice(sequence));
            return;
        }

        for (int i=0;i<n;i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sequence[depth] = i;
            calculateMinPriceToGetAll(n, depth+1, sequence, visited);
            visited[i] = false;
        }

    }

    private static int calculatePrice(int[] sequence) {

        int amount = 0;
        int[] discountedPrice = Arrays.copyOf(price, price.length);

        for (int i=0;i<sequence.length;i++) {
            ArrayList<DiscountInfo> discountInfos = discountInfo.get(sequence[i]);
            for (DiscountInfo discountInfo: discountInfos) {
                int num = discountInfo.getNum();
                discountedPrice[num] = discountInfo.calculateDiscountedPrice(discountedPrice[num]);
            }
            amount += discountedPrice[sequence[i]];
        }
        return amount;
    }

    static class DiscountInfo {
        int num;
        int discountAmount;

        public DiscountInfo(int num, int discountAmount) {
            this.num = num;
            this.discountAmount = discountAmount;
        }

        public int calculateDiscountedPrice(int price) {
            int result = price - discountAmount;
            return result <= 0 ? 1 : result;
        }

        public int getNum() {
            return num;
        }
    }
}
