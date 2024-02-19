//package boj1978_소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(isPrime(num)) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static boolean isPrime(int n) {
		if( n<=1) {
			return false;
		}
		if(n == 2 ) {
			return true;
		}
		if(n % 2 == 0) {
			return false;
		}
		for(int i = 3; i<= Math.sqrt(n); i+=2) { // 3이상인 홀수(증가범위는 루트n까지)
			if(n % i ==0) { // n % i 가 0이된다면 1과 자신을 제외한 약수가 따로 존재하는것 즉 소수가 아님
				return false;
			}
		}
		return true;
	}
}
