import java.io.*;
import java.util.*;

public class Main {

    static int max = Integer.MIN_VALUE;
    static List<Integer> list = new ArrayList<>();
    static List<Character> oper = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);

            if (i % 2 == 0) {
                list.add(c - '0');
            } else {
                oper.add(c);
            }
        }
        dfs(list.get(0), 0);
        System.out.println(max);
    }

    static void dfs(int total, int index) {
        if (index >= oper.size()) {
            max = Math.max(max, total);
            return;
        }

        // 현재 인덱스에서 a와 b 계산해보기
        int res1 = calculate(oper.get(index), total, list.get(index + 1));
        // 해당 인덱스로 끝까지 계산해보기
        dfs(res1, index + 1);

        // 괄호 넣었을 때
        if (index + 1 < oper.size()) {
            int next = calculate(oper.get(index + 1), list.get(index + 1), list.get(index + 2));
            int result = calculate(oper.get(index), total, next);
            dfs(result, index + 2);
        }

    }

    static int calculate(char op, int a, int b) {
        if (op == '+') return a + b;
        else if (op == '-') return a - b;
        else return a * b;
    }
}