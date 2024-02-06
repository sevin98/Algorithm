import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		Stack<Character> SK = new Stack<>();
		Stack<Character> LR = new Stack<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char c = str.charAt(i);
			if (Character.isDigit(c)) {
				cnt++;
			} else if (c == 'L') {
				LR.push(c);
			} else if (c == 'S') {
				SK.push(c);
			} else if (c == 'R') {
				if (!LR.isEmpty()) {
					LR.pop();
					cnt++;
				} else {
					break;
				}
			} else if( c == 'K') {
				if(!SK.isEmpty()) {
					SK.pop();
					cnt++;
				}else {
					break;
				}
			}

		}System.out.println(cnt);
	}
}
