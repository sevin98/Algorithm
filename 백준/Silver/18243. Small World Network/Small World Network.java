import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] adj;
    static int N, K;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a); // 양방향 그래프
        }
        for(int i = 1; i <= N; i++){
            if(!bfs(i)){
                System.out.println("Big World!");
                return;
            }
        }
        System.out.println("Small World!");
    }

    static boolean bfs(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;
        int seen = 1;

        while(!queue.isEmpty()){
            int cur = queue.poll();

            if(dist[cur] == 6) continue;

            for(int next : adj[cur]){
                if(dist[next] != -1) continue;
                dist[next] = dist[cur] + 1;
                if(dist[next] <= 6){
                    queue.add(next);
                    seen++;
                }
            }
        }
            return seen == N;
    }
}
