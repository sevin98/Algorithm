import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            Stack<Character> s = new Stack<>();
            String input = br.readLine();
            if (input.equals(".")) break;

            boolean isBalanced = true;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '(' || c == '[') s.push(c);
                else if (c == ')') {
                    if (s.isEmpty() || s.peek() != '(') {
                        isBalanced = false;
                        break;
                    } else s.pop();
                } else if (c == ']') {
                    if (s.isEmpty() || s.peek() != '[') {
                        isBalanced = false;
                        break;
                    } else s.pop();
                }
            }
            if (!s.isEmpty()) isBalanced = false;
            if (isBalanced) sb.append("yes\n");
            else sb.append("no\n");
        }
        System.out.println(sb);
    }
}