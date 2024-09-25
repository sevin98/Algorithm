import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dh = {0, 0, 0, 0, -1, 1};
    static int N, M, H, day;
    static int[][][] tomatos;
    static boolean[][][] check;
    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int h;
        int r;
        int c;
        int days;

        Tomato(int h, int r, int c, int days) {
            this.h = h;
            this.r = r;
            this.c = c;
            this.days = days;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatos = new int[H][N][M];
        check = new boolean[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int ii = 0; ii < M; ii++) {
                    tomatos[h][i][ii] = Integer.parseInt(st.nextToken());
                    if (tomatos[h][i][ii] == 1) {
                        q.offer(new Tomato(h, i, ii, 0));
                        check[h][i][ii] = true;
                    }
                }
            }
        }// 배열
        bfs();
        if (isTomatoCompleted()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }// main

    static void bfs() {
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();

            for (int d = 0; d < 6; d++) {
                int nh = tomato.h + dh[d];
                int nr = tomato.r + dr[d];
                int nc = tomato.c + dc[d];

                if (canMove(nh, nr, nc)) {
                    q.offer(new Tomato(nh, nr, nc, tomato.days + 1));
                    check[nh][nr][nc] = true;
                    day = tomato.days + 1;
                }
            }
        }
    }

    static boolean isTomatoCompleted() {
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int ii = 0; ii < M; ii++) {
                    if (tomatos[h][i][ii] == 0 && !check[h][i][ii]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static boolean canMove(int h, int r, int c) {
        return h >= 0 && r >= 0 && c >= 0 && h < H && r < N && c < M
                && tomatos[h][r][c] != -1 && !check[h][r][c];
    }
}