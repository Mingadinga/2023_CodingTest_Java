package BOJ.icpc;

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
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                Integer min = minHeap.poll();
                if (min == null) sb.append(0).append("\n");
                else sb.append(min).append("\n");
            } else {
                minHeap.add(command);
            }
        }

        System.out.print(sb);
    }
}
