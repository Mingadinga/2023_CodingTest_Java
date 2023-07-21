package BOJ.c_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1991 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Node head = new Node('A', null, null);

    static class Node {
        char value;
        Node left;
        Node right;

        private Node(char value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public static void insert(Node head, char value, char left, char right) {
            if (head.value == value) {
                head.left = (left == '.' ? null : new Node(left, null, null));
                head.right = (right == '.' ? null : new Node(right, null, null));
            }
            else {
                if (head.left != null) insert(head.left, value, left, right);
                if (head.right != null) insert(head.right, value, left, right);
            }
        }
    }

    static void preOrder(Node head) {
        if (head == null) return;
        sb.append(head.value);
        preOrder(head.left);
        preOrder(head.right);
    }

    static void midOrder(Node head) {
        if (head == null) return;
        midOrder(head.left);
        sb.append(head.value);
        midOrder(head.right);
    }

    static void postOrder(Node head) {
        if (head == null) return;
        postOrder(head.left);
        postOrder(head.right);
        sb.append(head.value);
    }

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            Node.insert(head, value, left, right);
        }

        preOrder(head);
        System.out.println(sb); sb.setLength(0);
        midOrder(head);
        System.out.println(sb); sb.setLength(0);
        postOrder(head);
        System.out.println(sb); sb.setLength(0);

    }

}
