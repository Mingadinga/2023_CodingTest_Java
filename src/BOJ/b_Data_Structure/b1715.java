package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class b1715 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            minHeap.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (minHeap.size() >= 2) {
            int c1 = minHeap.poll();
            int c2 = minHeap.poll();
            minHeap.add(c1 + c2);
            sum += c1 + c2;
        }

        System.out.println(sum);


    }
}
