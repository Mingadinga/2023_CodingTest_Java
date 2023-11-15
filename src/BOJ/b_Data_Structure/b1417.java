package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class b1417 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());

        for (int i=0;i<n-1;i++) {
            maxHeap.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        if (!maxHeap.isEmpty()) {
            while (maxHeap.peek() >= dasom) {
                int max = maxHeap.poll();
                maxHeap.add(max - 1);
                dasom++;
                count++;
            }
        }

        System.out.println(count);

    }

}
