//package boj5397_키로거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // tc 입력

		for (int tc = 1; tc <= T; tc++) {
			Stack<Character> s1 = new Stack<>();
			Stack<Character> s2 = new Stack<>();
			String str = br.readLine();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < str.length(); i++) { //한 글자씩 입력 받으면서
				switch (str.charAt(i)) {  // '<' 일떈 왼쪽껄 빼서 오른쪽에
				case '<':
					if (!s1.isEmpty()) {
						s2.push(s1.pop());
					}
					break;
				case '>':
					if (!s2.isEmpty()) { // '>' 일떈 오른쪽껄 빼서 왼쪽에
						s1.push(s2.pop());
					}
					break;
				case '-':
					if (!s1.isEmpty()) { // '-'일땐 왼쪽걸 지우고
						s1.pop();
					}
					break;
				default:
					s1.push(str.charAt(i)); // 이외엔 다 push
					break;
				}
			}
			while(!s1.isEmpty()) { //s1에있는걸 역순으로 다 s2에넣고
				s2.push(s1.pop());
			}
			while(!s2.isEmpty()) { //s2에있는걸 하나씩 빼면서 sb에 값저장
			sb.append(s2.pop());
			}
			System.out.println(sb); //sb출력
		}

	}
}
