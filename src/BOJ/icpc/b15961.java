package BOJ.icpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b15961 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] visited = new int[d+1];

        for (int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 첫번째 구간 배열에 대해 초기화
        int total=0, ans = 0;
        for (int i = 0; i < k; i++) {
            if(visited[arr[i]] ==0) total++;
            visited[arr[i]]++;
        }

        // 두번째 구간 배열부터 슬라이딩 윈도우 계산
        ans = total;
        for (int i = 1; i < N; i++) {
            // 업데이트 조건, 쿠폰 반영
            if (ans <= total) {
                if(visited[c]==0) ans = total+1;
                else ans = total;
            }

            // 제거되는 앞쪽 원소
            visited[arr[i-1]]--;
            if(visited[arr[i-1]]==0) total--;

            // 추가되는 뒤쪽 원소
            if(visited[arr[(i+k-1)%N]]==0) total++;
            visited[arr[(i+k-1)%N]]++;
        }

        System.out.println(ans);

    }

}
