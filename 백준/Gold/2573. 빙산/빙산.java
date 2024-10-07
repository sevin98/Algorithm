import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Ice {
        int r;
        int c;

        public Ice(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            int res = countIsland();

            if (res >= 2) {
                break;
            } else if (res == 0) {
                time = 0;
                break;
            }
            melt();
            time++;
        }
        System.out.println(time);
    }
    // 녹이는 bfs


    // 빙산 덩어리 세기
    static int countIsland() {
        boolean[][] check = new boolean[N][M];

        int cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (!check[r][c] && arr[r][c] > 0) {
                    dfs(r, c, check);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void dfs(int row, int col, boolean[][] check) {
        check[row][col] = true;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
                if (arr[nr][nc] > 0 && !check[nr][nc]) {
                    dfs(nr, nc, check);
                }
            }
        }
    }//dfs

    static void melt() {
        Queue<Ice> q = new LinkedList<>();
        boolean[][] check = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (arr[r][c] > 0) {
                    q.offer(new Ice(r, c));
                    check[r][c] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            Ice ice = q.poll();
            int sea = 0; //인접한 바닷물 갯수

            for (int d = 0; d < 4; d++) {
                int nr = ice.r + dr[d];
                int nc = ice.c + dc[d];

                if(nr >=0 && nc >= 0 && nr < N && nc < M){
                    if(!check[nr][nc] && arr[nr][nc] ==0){
                        sea++;
                    }
                }
            }
            if(arr[ice.r][ice.c] - sea < 0){ // 사면에 바다가 많아서 바다보다 낮아지면 0으로 변경
                arr[ice.r][ice.c] = 0;
            }else{
                arr[ice.r][ice.c] -= sea;
            }
        }
    }//bfs
}