package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s21204 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		final int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			int tn = Integer.parseInt(br.readLine());
			String[] inputStrings = br.readLine().split(" ");
			
			// 최빈수 기록 
			int[] numCount = new int[101]; int maxCount = 0;
			for (int i=0;i<inputStrings.length;i++) {
				int score = Integer.parseInt(inputStrings[i]);
				numCount[score]++;
				maxCount = Math.max(maxCount, numCount[score]);
			}
			
			// 최빈수 중 가장 큰 수 찾
			int result = 0;
			for (int i=0;i<101;i++) {
				if (numCount[i] == maxCount) {
					result = Math.max(result, i);
				}
			}
			sb.append("#").append(tn).append(" ").append(result).append("\n");
			
		}
		
		System.out.print(sb);
	}
}
