package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2075 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            int[] tokens = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int token : tokens) {
                if (minHeap.size() < n) minHeap.add(token);
                else if (minHeap.peek() < token){
                    minHeap.poll();
                    minHeap.add(token);
                }
            }
        }

        System.out.println(minHeap.poll());
    }
}
