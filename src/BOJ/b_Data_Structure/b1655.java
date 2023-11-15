package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b1655 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    /*
    max heap | min heap
    1 | -
    1 | 5
    1 2 | 5
    1 2 | 5 10
    -99 1 2 | 5 10
    -99 1 2 | 5 7 10
    -99 1 2 5 | 5 7 10

    힙 추가 : max heap 우선
    일관성 : max heap poll < min heap poll
    중간값 : man heap peek
     */

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {

            int x = Integer.parseInt(br.readLine());

            // 각 힙에 추가
            if (maxHeap.size() == minHeap.size()) {
                maxHeap.add(x);
            } else {
                minHeap.add(x);
            }

            // 최대힙 poll < 최소힙 poll 일관성 맞추기
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }

            // 중간값 출력
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
