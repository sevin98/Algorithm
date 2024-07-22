import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {

        int end, weight;

        Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

    static final int INF = 987654321;
    static int N, M, X;
    static List<ArrayList<Node>> list, reverse;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverse = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            reverse.get(end).add(new Node(start, weight));
        }
            int[] dist1 = dijkstra(list);
            int[] dist2 = dijkstra(reverse);

            int res = 0;
            for(int i = 1 ; i <= N; i++)
                res = Math.max(res, dist1[i] + dist2[i]);

        System.out.println(res);
    }

    private static int[] dijkstra(List<ArrayList<Node>> list) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        dist[X] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int cur = curr.end;

            if(!check[cur]){
                check[cur] = true;

                for(Node node : list.get(cur)){
                    if(!check[node.end] && dist[node.end] > node.weight + dist[cur]){
                        dist[node.end] = dist[cur] + node.weight;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist;
    }
}