//package boj28279_덱2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			switch (temp) {
			case "1":
				dq.offerFirst(Integer.parseInt(st.nextToken()));

				break;
			case "2":
				dq.offerLast(Integer.parseInt(st.nextToken()));

				break;
			case "3":
				if (!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append("\n");

				} else {
					sb.append(-1).append("\n");

				}
				break;
			case "4":
				if (!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");

				} else {
					sb.append(-1).append("\n");

				}
				break;
			case "5":
				sb.append(dq.size()).append("\n");

				break;
			case "6":
				if (dq.isEmpty()) {
					sb.append(1).append("\n");

				} else {
					sb.append(0).append("\n");

				}
				break;
			case "7":
				if (!dq.isEmpty()) {
					sb.append(dq.peekFirst()).append("\n");

				} else {
					sb.append(-1).append("\n");

				}
				break;
			case "8":
				if (!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");

				} else {
					sb.append(-1).append("\n");

				}
				break;
			}
		}
		System.out.println(sb);
	}
}
