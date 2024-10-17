import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] arr;
    static boolean[][][][] check;

    static class Info {
        int r, c, cnt, breakCnt;
        boolean isDay;

        public Info(int r, int c, int cnt, int breakCnt, boolean isDay) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.breakCnt = breakCnt;
            this.isDay = isDay;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M][K + 1][2];

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c) - '0';
            }
        }
        bfs();
    }

    static void bfs() {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(0, 0, 1, 0, true));
        check[0][0][0][1] = true;

        while (!q.isEmpty()) {
            Info curr = q.poll();
            int r = curr.r;
            int c = curr.c;

            if (r == N - 1 && c == M - 1) {
                System.out.println(curr.cnt);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                // 빈 칸일 경우
                if (arr[nr][nc] == 0) {
                    if (curr.isDay && !check[nr][nc][curr.breakCnt][0]) {
                        q.offer(new Info(nr, nc, curr.cnt + 1, curr.breakCnt, false));
                        check[nr][nc][curr.breakCnt][0] = true;
                    } else if (!curr.isDay && !check[nr][nc][curr.breakCnt][1]) {
                        q.offer(new Info(nr, nc, curr.cnt + 1, curr.breakCnt, true));
                        check[nr][nc][curr.breakCnt][1] = true;
                    }
                    // 벽일 경우
                } else {
                    if (curr.breakCnt < K && curr.isDay && !check[nr][nc][curr.breakCnt + 1][0]) {
                        q.offer(new Info(nr, nc, curr.cnt + 1, curr.breakCnt + 1, false));
                        check[nr][nc][curr.breakCnt + 1][0] = true;
                    } else if (curr.breakCnt < K && !curr.isDay && !check[r][c][curr.breakCnt][1]) {
                        q.offer(new Info(r, c, curr.cnt + 1, curr.breakCnt, true));
                        check[r][c][curr.breakCnt][1] = true;
                    }
                }
            }
        }
        System.out.println(-1); // 도착 불가능
    }
}