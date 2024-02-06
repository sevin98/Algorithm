import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		for(int i = 0; i<N ;i++) {
			stack.push(Integer.parseInt(br.readLine()));
		}
		int num = 0;
		while(!stack.isEmpty()) {
			if(num == 0) {
				num = stack.pop();
			}else {
				int a = stack.pop();
				if(num < a) {
					cnt++;
					num = a;
				}
			}
		}
		System.out.println(cnt);
	}
}
