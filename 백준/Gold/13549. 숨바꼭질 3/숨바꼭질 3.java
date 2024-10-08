import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int max = 100_000;
    static int[] check = new int[max+1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N));
    }// main

    static int bfs(int start) {
        Deque<Integer> q = new LinkedList<>();
        Arrays.fill(check, -1);
        q.add(start);
        check[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == K) {
                return check[cur];
            }

            if (cur - 1 >= 0 && check[cur - 1] == -1) {
                q.addLast(cur - 1);
                check[cur - 1] = check[cur] + 1;
            }

            if (cur * 2 <= max && check[cur * 2] == -1) {
                q.addFirst(cur * 2);
                check[cur * 2] = check[cur];
            }

            if (cur + 1 <= max && check[cur + 1] == -1) {
                q.addLast(cur + 1);
                check[cur + 1] = check[cur] + 1;
            }
        }
        return -1;
    }// bfs
}