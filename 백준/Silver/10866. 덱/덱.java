//package boj10866_덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			switch(temp) {
			case "push_front" :
				dq.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				dq.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				if(!dq.isEmpty()) {
					sb.append(dq.pollFirst()).append("\n");	
				}else {
					sb.append(-1).append("\n");
				}				
				break;
			case "pop_back" :
				if(!dq.isEmpty()) {
					sb.append(dq.pollLast()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case "size" :
				sb.append(dq.size()).append("\n");
				break;
			case "empty" :
				if(dq.isEmpty()) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
				break;
			case "front" :
				if(!dq.isEmpty()) {
					sb.append(dq.peekFirst()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			case "back" :
				if(!dq.isEmpty()) {
					sb.append(dq.peekLast()).append("\n");
				}else {
					sb.append(-1).append("\n");
				}
				break;
			}
		}System.out.println(sb);
	}
}
