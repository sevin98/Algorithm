import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adj;
    static int N, M, cnt;
    static boolean[] visited, child;

    public static int toInt(char c) {
        return c - 'A' + 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        child = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken().charAt(0));
            int b = toInt(st.nextToken().charAt(0));
            adj[a].add(b);
            child[b] = true;
        }

        st = new StringTokenizer(br.readLine());
        int police = Integer.parseInt(st.nextToken());
        for (int i = 0; i < police; i++) {
            int idx = toInt(st.nextToken().charAt(0));
            if (1 <= idx && idx <= N) {
                visited[idx] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            if(!child[i] && !adj[i].isEmpty() && !visited[i]) {
                dfs(i);
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int start) {
        for(int next : adj[start]){
            if(!visited[next]){
                visited[next] = true;
                cnt++;
                dfs(next);
            }
        }
    }
}