package BOJ.a_Data_Structure;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class b18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> queue = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());
        for (int i=0;i<T;i++) {
            String cmds[] = br.readLine().split(" ");
            if (cmds[0].compareTo("push") == 0) {
                queue.addLast(Integer.parseInt(cmds[1]));
                continue;
            } else if (cmds[0].compareTo("pop") == 0) {
                sb.append(queue.isEmpty() ? -1 : queue.removeFirst());
            } else if (cmds[0].charAt(0) == 's') {
                sb.append(queue.size());
            } else if (cmds[0].charAt(0) == 'e') {
                sb.append(queue.isEmpty() ? 1 : 0);
            } else if (cmds[0].charAt(0) == 'f') {
                sb.append(queue.isEmpty() ? -1 : queue.peekFirst());
            } else if (cmds[0].charAt(0) == 'b') {
                sb.append(queue.isEmpty() ? -1 : queue.peekLast());
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
