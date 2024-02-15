//package boj2075_N번째큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N 입력
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < N; i++) {
			String str = br.readLine(); // 한 줄 입력
			StringTokenizer st = new StringTokenizer(str);
			while (st.hasMoreTokens()) {
				pq.offer(Integer.parseInt(st.nextToken())); // 큰 수부터 우선순위 큐에 삽입
			}
		}
		for (int i = 0; i < N - 1; i++) { // 큐에서 N-1개의 수를 poll하여 버림
			pq.poll();
		}
		System.out.println(pq.poll()); // 남은 큐의 맨 위가 N번째로 큰 수
	}
}
