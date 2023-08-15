package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class b11286 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> minorMinHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> majorMinHeap = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for (int i=0;i<n;i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                sb.append(getMinAbs()).append("\n");
            }
            else if (x < 0) minorMinHeap.add(x);
            else majorMinHeap.add(x);
        }
        System.out.print(sb);
    }

    private static Integer getMinAbs() {
        Integer minor = minorMinHeap.peek();
        Integer major = majorMinHeap.peek();

        if (minor == null && major == null) return 0;
        else if (minor == null) return majorMinHeap.poll();
        else if (major == null) return minorMinHeap.poll();
        else if (-1 * minor <= major) return minorMinHeap.poll();
        else return majorMinHeap.poll();

    }
}
