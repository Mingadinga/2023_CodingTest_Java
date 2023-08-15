package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class b25192 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashSet<String> emoticonUsers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i=0;i<n;i++) {
            String chat = br.readLine();
            if (chat.compareTo("ENTER") == 0) {
                emoticonUsers.clear();
            } else if (!emoticonUsers.contains(chat)){
                emoticonUsers.add(chat);
                count++;
            }
        }

        System.out.println(count);

    }
}
