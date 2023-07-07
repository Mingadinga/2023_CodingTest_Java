package BOJ.b_Data_Structure;

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
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++) {
            int token = Integer.parseInt(br.readLine());
            if (token == 0) {
                if (maxHeap.isEmpty()) sb.append(0);
                else sb.append(maxHeap.poll());
                sb.append("\n");
            }
            else if (token > 0) {
                maxHeap.add(token);
            }
        }

        System.out.print(sb);

    }
}
