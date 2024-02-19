//package boj1018_체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static boolean[][] arr;
	public static int min = 64;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st1 = br.readLine(); // 입력값 
		StringTokenizer st = new StringTokenizer(st1);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr= new boolean[N][M];
		
		for(int r = 0 ; r<N; r++) {
			String str = br.readLine();
			
			for(int c = 0 ; c <M; c++) {
				if(str.charAt(c) == 'W') {
					arr[r][c] = true;
				}else {
					arr[r][c] = false;
				}
			}
		}
		int row = N - 7;
		int col = M - 7;
		for(int r = 0 ; r < row; r++) {
			for(int c = 0; c<col; c++) {
				find(r,c);
			}
		}
		System.out.println(min);
	}
	public static void find(int x , int y) {
		int endx = x + 8;
		int endy = y + 8;
		int cnt = 0;
		
		boolean color = arr[x][y];
		
		for(int i = x; i<endx; i++) {
			for(int j = y ; j < endy; j++) {
				if(arr[i][j] != color) {
					cnt++;
				}
				color = (!color);
			}
			color = !color;
		}
		cnt = Math.min(cnt, 64 - cnt);
		min = Math.min(min, cnt);
	}
}
