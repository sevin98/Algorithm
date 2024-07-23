import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v, w;
        public Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e){
            return w - e.w;
        }
    }

    static int N,M;
    static int INF = Integer.MAX_VALUE;
    static List<ArrayList<Edge>> adj;
    static int[] dist;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        dist = new int[N+1];

        adj = new ArrayList<>();
        for(int i = 0; i <= N; i++)
            adj.add(new ArrayList<>());

        for(int i = 0 ; i < M; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();

            adj.get(A).add(new Edge(B, C));
            adj.get(B).add(new Edge(A, C));
        }

        Arrays.fill(dist, INF);
        dijkstra();
        System.out.println(dist[N]);
    }

    static void dijkstra(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dist[1] = 0;

        while(!pq.isEmpty()){
            Edge e = pq.poll();
            for(Edge next : adj.get(e.v)){
                if(dist[next.v] > dist[e.v] + next.w){
                    dist[next.v] = dist[e.v] + next.w;
                    pq.offer(next);
                }
            }
        }
    }
}