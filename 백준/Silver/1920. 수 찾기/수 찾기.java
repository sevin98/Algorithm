//package boj1920_수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//이진트리..
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine()); // N입력
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr); // 정렬
		int M = Integer.parseInt(br.readLine()); // M입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (BinarySearch(arr, num)) {
				sb.append(1 + "\n");
			} else {
				sb.append(0 + "\n");
			}
		}
		System.out.print(sb);
	}

	public static boolean BinarySearch(int[] arr, int a) { //이진트리메소드
		int left = 0;
		int right = arr.length - 1;
        //0~ N-1 까지
		//left > right 가될떄까지
		while (left <= right) {
			int mid = (left + right) / 2;
			if (arr[mid] == a) {
				return true;
			} else if (arr[mid] < a) {
				left = mid + 1;
			} else if (arr[mid] > a) {
				right = mid - 1;
			}
		}
		return false;
	}

}
