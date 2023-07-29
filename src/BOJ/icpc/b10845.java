package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class b10845 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) execute(br.readLine().split(" "));
        System.out.print(sb);
    }

    private static void execute(String[] command) {
        char c = command[0].charAt(0);
        if(c == 'f') {
            sb.append(queue.isEmpty() ? -1 : queue.peekFirst());
        } else if(c == 'b') {
            sb.append(queue.isEmpty() ? -1 : queue.peekLast());
        } else if (c == 's') {
            sb.append(queue.size());
        } else if (c == 'e') {
            sb.append(queue.isEmpty() ? 1 : 0);
        } else if (c == 'p') {
            if (command[0].charAt(1) == 'u') {
                queue.addLast(Integer.parseInt(command[1]));
                return;
            } else if (command[0].charAt(1) == 'o' && !queue.isEmpty()){
                sb.append(queue.removeFirst());
            } else {
                sb.append(-1);
            }
        }
        sb.append("\n");
    }
}
