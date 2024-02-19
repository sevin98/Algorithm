//package boj2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		while (pq.size() < T) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		while (!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		System.out.print(sb);
	}
}
