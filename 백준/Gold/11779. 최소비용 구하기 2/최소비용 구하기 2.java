import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] list = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
        }
        while(M--> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
        }
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] dist = new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        int[] p = new int[N+1];

       PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

           @Override
           public int compare(int[] o1, int[] o2) {
               return o2[1]-o1[1];
           }
       });

        pq.add(new int[]{s, 0});

        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int cur = temp[0];
            int distance = temp[1];
            if(distance > dist[cur]) continue;
            for(int[] edge : list[cur]){
                int next = edge[0];
                int nextDistance = distance + edge[1];
                if(dist[next] <= nextDistance) continue;
                dist[next] = nextDistance;
                p[next] = cur;
                pq.add(new int[]{next, nextDistance});
            }
        }//while

        ArrayList<Integer> value= new ArrayList<>();
        for(int i = e ; i != 0; i = p[i]){
            value.add(i);
        }

        bw.write(dist[e] +"\n");
        bw.write(value.size() + "\n");
        for(int i = value.size()-1; i >= 0; i--){
            bw.write(String.valueOf(value.get(i) + " "));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
