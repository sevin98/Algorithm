//package boj11651_좌표정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j< 2; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.sort(arr, (a,b) -> {
			if(a[1] == b[1]) {
				return Integer.compare(a[0], b[0]);
			}else {
				return Integer.compare(a[1], b[1]);
			}
		});
		   for (int i = 0; i < N; i++) {
	            System.out.println(arr[i][0] + " " + arr[i][1]);
	        }
	}
}
