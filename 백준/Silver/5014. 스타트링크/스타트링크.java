import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int F,S,G; // floor, Start, Goal
    static int[] move;
    static int[] dr = new int[2]; // up , down
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dr[0] = Integer.parseInt(st.nextToken());
        dr[1] = -Integer.parseInt(st.nextToken());
        move = new int[F+1];
        bfs(S);
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[F+1];

        q.offer(start);
        check[start] = true;
        move[start] = 0;

        while(!q.isEmpty()){
            int position = q.poll();
            if(position == G){
                System.out.println(move[position]);
                return;
            }

            for(int i = 0 ; i < 2; i++){
                int next = position + dr[i];

                if(next > F || next < 1) continue;
                if(!check[next]){
                    check[next] = true;
                    q.offer(next);
                    move[next] = move[position] + 1 ;
                }
            }
        }
        System.out.println("use the stairs");
    }
}