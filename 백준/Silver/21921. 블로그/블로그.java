//package boj21921_블로그;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		if (X > N) {
			System.out.println("SAD");
			return;
		}
		int sum = 0;
		for (int i = 0; i < X; i++) {
			sum += arr[i];
		}
		int max = sum;
		int cnt = 1;
		for (int i = X; i < N; i++) {
			sum += arr[i] - arr[i - X];
			if (max < sum) {
				max = sum;
				cnt = 1;
			} else if (max == sum) {
				cnt++;
			}
		}
		if (max == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}
}
