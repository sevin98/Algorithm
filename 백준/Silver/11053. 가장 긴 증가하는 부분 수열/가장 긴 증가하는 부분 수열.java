//package 가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		int res = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;//dp배열값은 1로초기화
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1 ; j < i; j++) {
				if(arr[i] > arr[j])
					//i번째값을 기준으로 j 번째값보다 커지면
					// dp의 i번째값을 j보다 1씩 더해줌 
				dp[i] = Math.max(dp[i], dp[j]+1);
			}
			//반복문 한번 돌고 res에 맥스값 저장
			res = Math.max(dp[i], res);
		}
		sb.append(res);
		System.out.println(sb);
	}
}
