//package boj9012_괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static boolean isTrue(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0 ; i < str.length(); i++) {
			char ch = str.charAt(i);
			if( ch == '(') {
				stack.push(ch);
			}else if(ch == ')'){
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // tc입력
        for (int tc = 0; tc < T; tc++) {// tc start
            String str = br.readLine();
           if(isTrue(str)) {
        	   System.out.println("YES");
           }else {
        	   System.out.println("NO");
           }
        } // tc close
    }
}
