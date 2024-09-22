import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        String input = br.readLine();
        int value = 1;
        int res = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                st.push(input.charAt(i));
                value *= 2; //( : 2
            } else if(input.charAt(i) == '[') {
                st.push(input.charAt(i));
                value *= 3; //[ : 3
            } else if(input.charAt(i) == ')') {
                if(st.isEmpty() || st.peek() != '(') {
                    res = 0;
                    break;
                } else if(input.charAt(i-1) == '(') {
                    res += value;
                }
                st.pop();
                value /= 2;
            } else if(input.charAt(i) == ']') {
                if (st.isEmpty() || st.peek() != '[') {
                    res = 0;
                    break;
                } else if (input.charAt(i - 1) == '[') {
                    res += value;
                }
                st.pop();
                value /= 3;
            }
        }
        if(!st.isEmpty())
            System.out.println(0);
        else
            System.out.println(res);
    }
}