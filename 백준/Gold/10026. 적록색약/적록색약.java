//package 백준10026_적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] arr;
	static boolean[][] check;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		check = new boolean[N][N];
		
		for(int r = 0; r< N; r++) {
			String str = br.readLine();
			for(int c = 0; c< N; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		int generalcount = 0;
		int honglvcount = 0;
		
		//general
		for(int r = 0; r < N; r++) {
			for(int c = 0 ; c< N; c++) {
				if(!check[r][c]) {
					bfs(r,c, arr[r][c]);
					generalcount++;
				}
			}
		}
		
		//check배열 초기화
		for(int i = 0; i< N; i++) {
			Arrays.fill(check[i], false);
		}
		
		//배열값을 honglv값으로 바꾸고
		//honglv
		for(int r = 0 ; r< N; r++) {
			for(int c = 0; c< N; c++) {
				if(arr[r][c] == 'G') {//적록색약일때 초록색을찾으면 R로바꿈
					arr[r][c] = 'R';
				}
			}
		}
		
		//honglv bfs순회
		for(int r = 0 ; r< N; r++) {
			for(int c = 0 ;c<N; c++) {
				if(!check[r][c]) {
					bfs(r,c, arr[r][c]);
					honglvcount++;
				}
			}
		}
		System.out.println(generalcount + " " + honglvcount);
		
	}
	
	static void bfs(int r, int c, char color) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[]{r,c});
		check[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int curr = current[0];
			int curc = current[1];			
			
			for(int i = 0; i<4; i++) {
				int nr = curr + dr[i];
				int nc = curc + dc[i];
				
				//배열범위 안에있고 색상이 같을때
				if(nr >=0 && nr < N && nc >= 0 && nc < N && !check[nr][nc] && arr[nr][nc] == color) {
					q.offer(new int[] {nr, nc});
					check[nr][nc] = true;
				}
			}
		}
	}
}
