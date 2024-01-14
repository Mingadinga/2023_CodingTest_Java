package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class p1959 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		final int T = Integer.parseInt(br.readLine());
		
		for (int i=0;i<T;i++) {
			String[] nm = br.readLine().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);
			
			int[] A = new int[N];
			String[] awithString = br.readLine().split(" ");
			for (int j=0;j<N;j++) {
				A[j] = Integer.parseInt(awithString[j]); 
			}
			
			int[] B = new int[M];
			String[] bwithString = br.readLine().split(" ");
			for (int j=0;j<M;j++) {
				B[j] = Integer.parseInt(bwithString[j]); 
			}
			
			int result = getMaxMultipleSum(A, B);
			
			sb.append("#").append(i+1).append(" ").append(result).append("\n");
			
		}
		
		System.out.print(sb);
		
		
	}

	private static int getMaxMultipleSum(int[] a, int[] b) {
		
		int[] shortArray; int[] longArray;
		int difference = Math.abs(a.length - b.length);
		
		if (a.length >= b.length) {
			shortArray = b;
			longArray = a;
		} else {
			shortArray = a;
			longArray = b;
		}
		
		int max = 0;
		for (int i=0;i<=difference;i++) {
			int result = getMultipleSumWithIndex(shortArray, longArray, i);
			max = Math.max(max, result);
		}
		return max;
	}

	private static int getMultipleSumWithIndex(int[] shortArray, int[] longArray, int startIndexOfLongArray) {
		int result = 0;
		for (int j=0;j<shortArray.length;j++) {
			result += shortArray[j] * longArray[j+startIndexOfLongArray]; 
		}
		return result;
	}


}
