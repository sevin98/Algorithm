import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N, K, res;
    static int max = 100_000;
    static int[] check = new int[max+1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    static int bfs(int start, int arrive) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        check[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == arrive) {
                return check[curr];
            }

            if (curr - 1 >= 0 && check[curr - 1] == 0) {
                q.offer(curr - 1);
                check[curr - 1] = check[curr] + 1;
            }

            if (curr + 1 <= max && check[curr + 1] == 0) {
                q.offer(curr + 1);
                check[curr + 1] = check[curr] + 1;
            }

            if (curr * 2 <= max && check[curr * 2] == 0) {
                q.offer(curr * 2);
                check[curr * 2] = check[curr] + 1;
            }
        }
        return -1;
    }
}