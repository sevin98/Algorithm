import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] height = new int[N];
        int[] res = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                stack.pop();
            }

            if (!stack.isEmpty())
                res[i] = stack.peek() + 1;
            else
                res[i] = 0;

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(res[i] + " ");
        }
        System.out.println(sb);


    }
}