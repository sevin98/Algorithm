//package boj1021_회전하는큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Deque<Integer> dq = new ArrayDeque<>();
		int cnt = 0; // 이동횟수를 계산해줄cnt 변수
		for (int i = 1; i <= N; i++) {
			dq.offer(i); // 0번째인덱스부터 숫자 1번넣음
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int index = getIndex(dq, num);

			int size = dq.size();
			int move;
			if (index < size - index) {
				move = index;
			} else {
				move = size - index;
			}
			for (int j = 0; j < move; j++) {
				if (index < size - index) {
					int first = dq.pollFirst();
					dq.offerLast(first);
					cnt++;
				} else {
					int last = dq.pollLast();
					dq.offerFirst(last);
					cnt++;
				}
			}
			dq.pollFirst();
		}
		System.out.println(cnt);
	}

	static int getIndex(Deque<Integer> dq, int target) {
		int index = 0;
		for (int num : dq) {
			if (num == target)
				return index;
			index++;
		}
		return -1;
	}
}
