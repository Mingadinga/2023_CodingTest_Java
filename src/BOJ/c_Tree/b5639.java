package BOJ.c_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b5639 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Node {
        Integer value;
        Node left, right;

        public Node(Integer value) {
            this.value = value;
        }

        public void insert(Integer n) {
            if (n < this.value) {
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }
            else {
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        Node head = new Node(Integer.parseInt(br.readLine()));
        while(true) {
            String input = br.readLine();
            if(input == null || input.compareTo("") == 0) break;
            head.insert(Integer.parseInt(input));
        }
        postOrder(head);
    }

}
