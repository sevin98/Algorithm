import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static final int RED = 1;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] colors;
    static boolean checkBipartite;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int TEST_CASE = sc.nextInt();

        while (TEST_CASE-- > 0) {

            // 정점의 개수 20_000
            int V = sc.nextInt();
            // 간선의 갯수 200_000
            int E = sc.nextInt();

            colors = new int[V + 1];
            adj = new ArrayList<>();
            checkBipartite = true;

            for (int i = 0; i <= V; i++) {
                adj.add(new ArrayList<>());
                colors[i] = 0;
            }

            while (E-- > 0) {
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();

                adj.get(v1).add(v2);
                adj.get(v2).add(v1);
            }
            for (int i = 1; i <= V; i++) {
                if (!checkBipartite) break;

                if (colors[i] == 0) {
                    bfs(i, RED);
                }
            }
            sb.append(checkBipartite ? "YES" : "NO").append("\n");
        }//tc
        System.out.println(sb);
    }//main

    static void bfs(int start, int color) {
        Queue<Integer> q = new LinkedList<>();
        colors[start] = color;
        q.offer(start);

        while(!q.isEmpty() && checkBipartite) {
            int cur = q.poll();

            // cur노드와 관련된 모든 노드 탐색
            for(int num : adj.get(cur)){
                // 바ㅣㅇ문안한 노드라면
                if(colors[num]==0){
                    q.offer(num);
                    colors[num] = colors[cur] * -1;
                }
                // 방문한 노드라면
                else if(colors[num] + colors[cur] != 0){
                    checkBipartite = false;
                    return;
                }
            }
        }
    }
}