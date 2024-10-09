import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, K, res;
    static int max = 100_000;
    static int[] check = new int[max+1];
    static int[] before = new int[max+1];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if(N == K){
            System.out.println(0);
            System.out.println(N);
        }
        else{
            res = bfs(N);
            StringBuilder sb = new StringBuilder();
            sb.append(check[K]).append("\n");
            Stack<Integer> stack = new Stack<>();
            int after = K;
            while(after != N){
                stack.push(after);
                after = before[after];
            }
            stack.push(N); // 마지막 값

            while(!stack.isEmpty()){
                sb.append(stack.pop()).append(" ");
            }
            System.out.println(sb);
        }
    }
    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
//        check[start] = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            int pos = q.poll();

            if (pos == K) {
                return check[pos];
            }

            // 뒤로 한 칸
            if (pos > 0 && check[pos - 1] == 0) {
                q.offer(pos - 1);
                check[pos - 1] = check[pos] + 1;
                before[pos - 1] = pos;
            }
            // 앞으로 한 칸
            if (pos + 1 <= max && check[pos + 1] == 0) {
                q.offer(pos + 1);
                check[pos + 1] = check[pos] + 1;
                before[pos + 1] = pos;
            }
            // 점프 두칸
            if (pos * 2 <= max && check[pos * 2] == 0) {
                q.offer(pos * 2);
                check[pos * 2] = check[pos] + 1;
                before[pos * 2] = pos;
            }
        }
        return -1;
    }
}