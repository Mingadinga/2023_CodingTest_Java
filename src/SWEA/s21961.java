package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class s21961 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws Exception {
		final int T = Integer.parseInt(br.readLine());
		
		for (int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			
			// input board
			int[][] inputBoard = new int[N][N];
			for (int i=0;i<N;i++) {
				String[] inputStrings = br.readLine().split(" ");
				for (int j=0;j<N;j++) {
					inputBoard[i][j]= Integer.parseInt(inputStrings[j]);
				}
			}
			
			// rotate board
			Board board = new Board(inputBoard);
			Board[] snapShotArr = new Board[3];
			for (int i=2;i>=0;i--) {
				board = board.rotate();
				snapShotArr[i] = board; 
			}
			
			// print result
			sb.append("#").append(t+1).append("\n");
			for (int rowIndex=0;rowIndex<N;rowIndex++) {
				for (int d=0;d<3;d++) {
					sb.append(snapShotArr[d].getRow(rowIndex)).append(" ");
				}
				sb.append("\n");
			}
			
			
			
			
			
		}
		System.out.print(sb);
	}
	
	public static class Board {
		int[][] board;
		
		public Board(int[][] inputBoard) {
			board = inputBoard;
		}

		public Board rotate() {
			int N = board[0].length;
			int[][] newBoard = new int[N][N];
			
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {
					newBoard[i][j] = board[j][N-1-i];
				}
			}
			
			return new Board(newBoard);
		}
		
		public String getRow(int i) {
			int N = board[0].length;
			StringBuilder sbBuilder = new StringBuilder();
			
			for (int j=0;j<N;j++) {
				sbBuilder.append(board[i][j]);
			}
			return sbBuilder.toString();
		}
		
		
	}
}
