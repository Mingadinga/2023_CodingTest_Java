package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class b10866 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) execute(br.readLine().split(" "));
        System.out.print(sb);
    }

    private static void execute(String[] command) {
        char c = command[0].charAt(0);
        if(c == 'f') {
            sb.append(deque.isEmpty() ? -1 : deque.peekFirst());
        } else if(c == 'b') {
            sb.append(deque.isEmpty() ? -1 : deque.peekLast());
        } else if (c == 's') {
            sb.append(deque.size());
        } else if (c == 'e') {
            sb.append(deque.isEmpty() ? 1 : 0);
        } else {
            if (command[0].compareTo("push_front") == 0) {
                deque.addFirst(Integer.parseInt(command[1])); return;
            } else if (command[0].compareTo("push_back") == 0) {
                deque.addLast(Integer.parseInt(command[1])); return;
            } else if (command[0].compareTo("pop_front") == 0 && !deque.isEmpty()) {
                sb.append(deque.pollFirst());
            } else if (command[0].compareTo("pop_back") == 0 && !deque.isEmpty()) {
                sb.append(deque.removeLast());
            } else {
                sb.append(-1);
            }
        }
        sb.append("\n");
    }
}