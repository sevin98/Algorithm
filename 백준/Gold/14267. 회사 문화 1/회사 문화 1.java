import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int[] comple;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 5 3
         * -1 1 2 3 4
         * 2 2
         * 3 4
         * 5 6
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        comple = new int[N+1];

        for(int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int senior = Integer.parseInt(st.nextToken());
            if(senior != -1){
                //사장 아니면
                adj[senior].add(i);
            }
        }

        for(int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            comple[i] += w;
        }
        dfs(1);

        for(int i = 1; i<= N; i++){
            System.out.print(comple[i] + " ");
        }
    }
    public static void dfs(int idx){

        for(int i = 0 ; i < adj[idx].size(); i++){
            int child = adj[idx].get(i);
            comple[child] += comple[idx];
            dfs(child);
        }
    }
}
