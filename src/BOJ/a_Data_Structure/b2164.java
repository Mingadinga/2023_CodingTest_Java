package BOJ.a_Data_Structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class b2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<=n; i++) deque.addLast(i);

        while(deque.size() != 1) {
            deque.removeFirst();
            deque.addLast(deque.removeFirst());
        }

        System.out.print(deque.getLast().intValue());
    }
}

