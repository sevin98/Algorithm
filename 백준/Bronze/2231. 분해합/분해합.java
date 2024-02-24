//package boj2231_분해합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		int res = 0;
		for (int i = 1; i < N; i++) {
			if (bunhaehab(i) == N) {
				res = i;
				break;
			}
		}
		System.out.println(res);
	}
	static int bunhaehab(int n) {
		int sum = n;
		while (n != 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
}
