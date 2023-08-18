package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b16953 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(a);

        HashMap<Integer, Integer> levels = new HashMap<>();
        levels.put(a, 1);

        while (! queue.isEmpty()) {
            int head = queue.pollFirst();

            long try1 = head * 2L;
            long try2 = (head * 10L) + 1;

            if (try1 < b) {
                queue.add((int) try1);
                levels.put((int) try1, levels.get(head)+1);
            }
            if (try2 < b) {
                queue.add((int) try2);
                levels.put((int) try2, levels.get(head)+1);
            }

            if (try1 == b) {
                levels.put((int) try1, levels.get(head)+1);
                break;
            }
            if (try2 == b) {
                levels.put((int) try2, levels.get(head)+1);
                break;
            }
        }

        int level = levels.getOrDefault(b, -1);

        System.out.println(level);


    }
}
