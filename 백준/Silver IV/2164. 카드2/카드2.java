//package boj2164_카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<>();
		int N = Integer.parseInt(br.readLine()); // N입력
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		while (q.size() > 1) {// q사이즈가 1이 될때까지 즉 한장이 남을때까지
			q.poll(); // 한장 버리고
			q.offer(q.poll()); // 맨 윗장을 맨 밑으로 옮긴다
		}
		System.out.println(q.peek());
	}

}
