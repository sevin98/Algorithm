import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX_LENGTH = 5_000;
    static int[] data, prev, next;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        data = new int[N + 1];
        prev = new int[N + 1];
        next = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            data[i] = i;
            prev[i] = (i == 1) ? N : i - 1;
            next[i] = (i == N) ? 1 : i + 1;
        }

        int current = 1;
        int cnt = N;

        sb.append("<");

        while (cnt > 0) {
            for (int i = 0; i < K - 1; i++) {
                current = next[current];
            }

            sb.append(data[current]);

            if (cnt > 1) {
                sb.append(", ");
            }

            prev[next[current]] = prev[current];
            next[prev[current]] = next[current];

            current = next[current];

            cnt--;
        }
        sb.append(">");
        System.out.println(sb);
    }
}