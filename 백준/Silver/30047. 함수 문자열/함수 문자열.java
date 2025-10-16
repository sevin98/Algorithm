import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int N = s.length();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // 앞에서부터 순회하면 재귀로 풀어야함
        for (int i = N - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'x':
                    // x 는 0으로 평가(evaluate)됨
                    stack.push(0);
                    break;
                case 'g':
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                        return;
                    }
                    stack.push(stack.pop() + 1);// 현재까지 평가된거에 1을 더해
                    break;
                case 'f':
                    if(stack.size() < 2){
                        System.out.println(-1);
                        return;
                    }
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(Math.min(a,b));
                    break;
                default :
                    System.out.println(-1);
                    return;
            }
        }
        System.out.println(stack.size() == 1 ? stack.pop() : -1);
    }
}
