package BOJ.b_Data_Structure;

/*
음수 - 최대힙
양수 - 최소힙
0 -> 음수힙에서 poll한 값, 양수힙에서 poll한 값의 절댓값을 비교
        더 작은 절대값을 가진 힙에서 poll, 같으면 음수힙에서 제거
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11286 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static PriorityQueue<Integer> minorMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> majorMinHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            int command = Integer.parseInt(br.readLine());
            if (command == 0) {
                getMinAbs();
            } else if (command > 0) {
                majorMinHeap.add(command);
            } else {
                minorMaxHeap.add(command);
            }
        }
        System.out.print(sb);
    }

    private static void getMinAbs() {
        Integer minorAbsMin = minorMaxHeap.peek();
        Integer majorAbsMin = majorMinHeap.peek();

        if(minorAbsMin == null && majorAbsMin == null) sb.append(0);
        else if (minorAbsMin == null) sb.append(majorMinHeap.poll());
        else if (majorAbsMin == null) sb.append(minorMaxHeap.poll());
        else {
            if (-minorAbsMin > majorAbsMin) sb.append(majorMinHeap.poll());
            else if (-minorAbsMin < majorAbsMin || -minorAbsMin == majorAbsMin) sb.append(minorMaxHeap.poll());
        }
        sb.append("\n");
    }
}
