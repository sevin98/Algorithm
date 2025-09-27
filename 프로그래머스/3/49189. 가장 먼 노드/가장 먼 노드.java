import java.util.*;

class Solution {
    
    static final int start = 1;
    
    public int solution(int n, int[][] edge) {
        List<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edge){
            int v = e[0];
            int ed = e[1];
            
            graph[v].add(ed);
            graph[ed].add(v);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            // cur 정점에서 갈 수 있는 노드들이 next
            for(int next : graph[cur]){
                if(dist[next] != -1){
                    continue;
                }
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }
        int cnt = 0;
        int max = 0;
        for(int i = 1; i<= n; i++){
            if(dist[i] > max) max = dist[i];
        }
        for(int i = 1; i <= n; i++){
            if(dist[i] == max) cnt++;
        }
        return cnt;
    }
}