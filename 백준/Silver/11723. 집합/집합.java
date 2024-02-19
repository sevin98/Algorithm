//package boj11723_집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int M = Integer.parseInt(br.readLine()); // 연산 수
        StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int num;
            switch (command) {
                case "add":
                    num = Integer.parseInt(input[1]);
                    stack.push(num);
                    break;
                case "remove":
                    num = Integer.parseInt(input[1]);
                    stack.remove((Integer) num);
                    break;
                case "check":
                    num = Integer.parseInt(input[1]);
                    sb.append(stack.contains(num) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(input[1]);
                    if (stack.contains(num)) {
                        stack.remove((Integer) num);
                    } else {
                        stack.push(num);
                    }
                    break;
                case "all":
                    stack.clear();
                    for (int j = 1; j <= 20; j++) {
                        stack.push(j);
                    }
                    break;
                case "empty":
                    stack.clear();
                    break;
            }
        }
        System.out.print(sb);
    }
}
