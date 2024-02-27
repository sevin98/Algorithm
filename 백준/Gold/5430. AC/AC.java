//package boj5430_AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // tc입력
		for (int tc = 1; tc <= T; tc++) { // tc start
			String str = br.readLine(); // 실행할 함수
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine(), "[],"); // 배열을 대괄호와 , 제외하고 숫자만String으로 입력받기
			for (int i = 0; i < N; i++) {
				dq.offer(Integer.parseInt(st.nextToken()));
			}
			AC(dq, str);
		} // tc close
	}

	static void AC(Deque<Integer> dq, String command) {
		boolean reverse = false; // 정상상태
		boolean error = false; // 정상상태
		for (char c : command.toCharArray()) { // 주어진 명령어 순회
			if (c == 'R') {
				reverse = !reverse; // R이나오면 뒤집기 실행하진 않고 뒤집기 상태를 false에서 true로 변경
			} else if (c == 'D') {
				if (dq.isEmpty()) { // D명령어에선 덱이 비어있으면 error상태변경
					error = true;
					break; // 종료
				}
				if (reverse) {
					dq.pollLast(); // reverse가 true라면 뒤 값 제거
				} else {
					dq.pollFirst();
				}
			}
		}

		if (error) { // error 상태가 true라면 에러출력
			System.out.println("error");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			if (!dq.isEmpty()) {
				if (reverse) {
					sb.append(dq.pollLast()); // reverse가 true라면 (뒤집힌상태) 뒤에서부터 sb에 담기
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollLast()); // 반복하면서 쉼표넣기
					}
				} else {
					sb.append(dq.pollFirst()); // reverse가 false인 상태(정상상태)
					while (!dq.isEmpty()) {
						sb.append(",").append(dq.pollFirst());
					}
				}
			}
			sb.append("]");
			System.out.println(sb.toString());
		}
	}
}