package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class b1963 {

    static private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static private StringBuilder sb = new StringBuilder();
    static private boolean[] isNotPrime = new boolean[10_000];
    static private boolean[] visited;


    public static void main(String[] args) throws IOException {

        // 1000부터 9999까지 모든 소수 구하기
        isNotPrime[0] = isNotPrime[1] = true;
        for(int i=2; i*i<10_000; i++){
            if(!isNotPrime[i]){
                for(int j=i*i; j<10_000; j+=i) isNotPrime[j] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());

        for (int i=0;i<t;i++) {
            visited = new boolean[10_000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(bfs(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    static int[] d = {1000, 100, 10, 1};
    static private int bfs(int start, int end) {

        Deque<State> queue = new ArrayDeque<>();
        queue.addLast(new State(start, 0)); visited[start] = true;

        while (!queue.isEmpty()) {
            State head = queue.pollFirst();
            int headNum = head.number;
            int count = head.count;

            if (start == end) {
                return count;
            }

            for (int i=0;i<4;i++) {
                int val = headNum / d[i] / 10;
                int mod = headNum % d[i];
                for (int j=0;j<10;j++) {
                    if (i == 0 && j == 0) continue;
                    int changed = (val * d[i] * 10) + (j * d[i]) + mod;
                    if (changed == end) {
                        return count+1;
                    }
                    if (visited[changed] || isNotPrime[changed]) continue;
                    queue.addLast(new State(changed, count+1)); visited[changed] = true;
                }
            }
        }

        return 0;

    }

    static class State {
        int number, count;

        public State(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
}
