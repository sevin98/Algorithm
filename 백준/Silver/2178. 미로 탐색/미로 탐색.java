import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr, dist;
    static boolean[][] visited;
    static int n , m;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dist = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0 ; i < n; i++){
            String line = br.readLine();
            for(int j = 0 ; j < m; j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    static int bfs(int start, int end){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, end});
        dist[start][end] = 1;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int r = cur[0];
            int c = cur[1];

            if(r == n-1 && c == m-1){
                return dist[r][c];
            }

            for(int d = 0; d < 4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];


                if(nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 1 && dist[nr][nc] == 0){
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        return -1;
    }
}
