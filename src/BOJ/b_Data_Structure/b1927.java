package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1927 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                minHeap.add(x);
            } else if (x == 0) {
                if (minHeap.isEmpty()) {
                    sb.append("0").append("\n");
                } else {
                    int min = minHeap.poll();
                    sb.append(min).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}
