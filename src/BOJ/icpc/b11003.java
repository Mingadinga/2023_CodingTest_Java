package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class b11003 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int l = Integer.parseInt(s[1]);

        Deque<Node> deque = new ArrayDeque<>();

        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < n; i++) {
            while(!deque.isEmpty() && deque.peekLast().value > numbers[i]) {
                deque.removeLast();
            }
            deque.addLast(new Node(numbers[i], i));
            if(deque.getFirst().index <= i-l) deque.removeFirst();

            sb.append(deque.peekFirst().value).append(" ");
        }

        System.out.println(sb);

    }

    static class Node {
        public int value;
        public int index;

        Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
