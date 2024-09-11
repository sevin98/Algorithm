import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < N; tc++) {
            boolean isValid = true;
            Stack<Character> stack = new Stack<>();

            String input = br.readLine();
            if (input.length() % 2 != 0) {
                sb.append("NO\n");
                continue;
            }
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '('){
                    stack.push(c);
                }
                else if (c == ')'){
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) isValid = false;
            if(isValid) sb.append("YES\n");
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
}