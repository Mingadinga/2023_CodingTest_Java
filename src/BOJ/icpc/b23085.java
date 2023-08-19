package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b23085 {

    static final int H = 0;
    static final int T = 1;
    static int totalT;
    static int n;
    static int k;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        totalT = n;

        int tCount = 0;
        char[] curState = br.readLine().toCharArray();
        for (int i=0;i<curState.length;i++) {
            if (curState[i] == 'T') tCount++;
        }

        if (tCount == n) System.out.println(0);

        bfs(tCount);

    }

    private static void bfs(int tCount) {

        Deque<Item> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];

        queue.addLast(new Item(tCount, 0));
        visited[tCount] = true;

        while (!queue.isEmpty()) {
            Item current = queue.pollFirst();
            int curT = current.tCount;
            int curH = n - curT;
            int curGame = current.gameCount;

            for (int x=0;x<=k;x++) {
                if (curH < x || curT < k-x) continue;
                int nextT = curT + (2 * x) - k;

                if (nextT == n) {
                    System.out.println(curGame + 1);
                    return;
                }

                if (visited[nextT]) continue;

                visited[nextT] = true;
                queue.addLast(new Item(nextT, curGame+1));
            }

        }

        System.out.println(-1);


    }

    private static class Item {
        int tCount, gameCount;

        public Item(int tCount, int gameCount) {
            this.tCount = tCount;
            this.gameCount = gameCount;
        }
    }

}
