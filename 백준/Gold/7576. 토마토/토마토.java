import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int N, M, day;
    static int[][] tomatos;
    static boolean[][] check;
    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int r;
        int c;
        int days;

        Tomato(int r, int c, int days) {
            this.r = r;
            this.c = c;
            this.days = days;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tomatos = new int[M][N];
        check = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < N; ii++) {
                tomatos[i][ii] = Integer.parseInt(st.nextToken());
                if (tomatos[i][ii] == 1) {
                    q.offer(new Tomato(i, ii, 0));
                    check[i][ii] = true;
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

            for (int d = 0; d < 4; d++) {
                int nr = tomato.r + dr[d];
                int nc = tomato.c + dc[d];

                if (canMove(nr, nc)) {
                    q.offer(new Tomato(nr, nc, tomato.days + 1));
                    check[nr][nc] = true;
                    day = tomato.days + 1;
                }
            }
        }
    }

    static boolean isTomatoCompleted() {
        for (int i = 0; i < M; i++) {
            for (int ii = 0; ii < N; ii++) {
                if (tomatos[i][ii] == 0 && !check[i][ii]) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < M && c < N && tomatos[r][c] != -1 && !check[r][c];
    }
}