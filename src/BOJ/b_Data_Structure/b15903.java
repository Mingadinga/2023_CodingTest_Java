package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b15903 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Long> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        long n = Long.parseLong(input[0]);
        long m = Long.parseLong(input[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<n;i++) {
            minHeap.add(Long.parseLong(st.nextToken()));
        }

        for (int i=0;i<m;i++) {
            long x = minHeap.poll();
            long y = minHeap.poll();
            long sum = x + y;
            minHeap.add(sum);
            minHeap.add(sum);
        }

        long score = 0L;
        while (!minHeap.isEmpty()) {
            score += minHeap.poll();
        }
        System.out.println(score);

    }
}
