import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int row, col, cnt, breakCnt;

        public Info(int row, int col, int cnt, int breakCnt) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.breakCnt = breakCnt;
        }
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, K;
    static int[][] arr;
    static boolean[][][] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M][K + 1];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) - '0';
            }
        }
        bfs();
    }
    static void bfs(){
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0, 1, 0));
        check[0][0][0] = true;
        while(!q.isEmpty()){
            Info info = q.poll();
            int row = info.row;
            int col = info.col;

            if(row == N-1 && col == M-1){
                System.out.println(info.cnt);
                return;
            }
            for(int d= 0 ;d <4; d++){
                int nr = row + dr[d];
                int nc = col + dc[d];

                if(nr < 0 || nc <0 || nr >= N || nc >= M) continue;;

                if(arr[nr][nc] == 0 && !check[nr][nc][info.breakCnt]){
                    q.offer(new Info(nr, nc, info.cnt+1, info.breakCnt));
                    check[nr][nc][info.breakCnt] = true;
                }else if(arr[nr][nc] == 1 && info.breakCnt < K && !check[nr][nc][info.breakCnt +1]){
                    q.offer(new Info(nr, nc, info.cnt+1, info.breakCnt+1));
                    check[nr][nc][info.breakCnt+1] = true;
                }
            }
        }
        System.out.println(-1);
    }
}