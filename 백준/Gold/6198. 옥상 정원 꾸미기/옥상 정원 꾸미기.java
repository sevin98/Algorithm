import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        long sum = 0 ;
        for(int i = 0 ; i < N; i++){
            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && height >= stack.peek())
                stack.pop();

            stack.push(height);
            sum += stack.size()-1;
        }
        System.out.println(sum);
    }
}