//package boj2775_부녀회장이될테야;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int k;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			k = Integer.parseInt(br.readLine()); // k층
			n = Integer.parseInt(br.readLine()); // k호
			// k층에 거주하려면 k-1층의 0호부터 n호까지의 인원수를 구해야 함
			// 재귀로 호출
			System.out.println(apartment(k,n));
		}//tc close;
	}
	// k와 n을 입력했을때 누적합을 구해주는 함수
	static int apartment(int k, int n) {

		if (k == 0) { // 0층일땐 n만큼만 누적해서 리턴
			return n;
		} else { // 1층 이상일땐
			int sum = 0;
			for (int i = 1; i <= n; i++) {
				sum += apartment(k - 1, i); // k가 1층일때 까지 반복
			}
			return sum;
		}
	}
}
