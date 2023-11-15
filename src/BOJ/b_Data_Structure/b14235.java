package BOJ.b_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b14235 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int firstToken = Integer.parseInt(st.nextToken());

            if (firstToken == 0) {
                givePresent();
            } else {
                addPresent(st, firstToken);
            }
        }

        System.out.print(sb);

    }

    private static void addPresent(StringTokenizer st, int firstToken) {
        for (int j = 0; j< firstToken; j++) {
            maxHeap.add(Integer.valueOf(st.nextToken()));
        }
    }

    private static void givePresent() {
        if (maxHeap.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(maxHeap.poll()).append("\n");
        }
    }
}
