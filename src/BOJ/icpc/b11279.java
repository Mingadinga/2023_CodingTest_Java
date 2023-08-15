package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11279 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                Integer max = maxHeap.poll();
                if (max == null) sb.append(0).append("\n");
                else sb.append(max).append("\n");
            } else {
                maxHeap.add(command);
            }
        }

        System.out.print(sb);
    }
}
