import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			String str = sc.next();

			int stack = 0;
			int result = 0;

			for (int i = 0; i < str.length(); i++) {
				// 여는 괄호가 나오면 stack +1;
				// 여는괄호를 먼저 비교하면 레이저() 를 비교할때 중복됨
				char c = str.charAt(i);
				if (c == '(' && str.charAt(i + 1) == ')') {
					result += stack;
					i++;
				} else if (c == '(') {
					stack++;
				} else {
					// 닫는괄호 : 조각 +1 , 스택 -1;
					result++;
					stack--;
				}
			}
			System.out.println(result);
	}
}
