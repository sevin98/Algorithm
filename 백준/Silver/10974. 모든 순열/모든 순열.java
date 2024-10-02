import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr, res;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        check = new boolean[N];
        res = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        backTrack(0);
        System.out.println(sb);
    }

    static void backTrack(int depth) {
        if (depth == N) {
            for (int num : res) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (check[i])
                continue;
             else {
                check[i] = true;
                res[depth] = i + 1;
                backTrack(depth + 1);
                check[i] = false;
            }
        }
    }
}