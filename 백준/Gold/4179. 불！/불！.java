import java.io.*;
import java.util.*;

public class Main {

    static char[][] arr;
    static boolean[][] checkFire;
    static boolean[][] checkJihun;
    static int R, C, res;
    static Queue<arrInfo> jihun;
    static Queue<arrInfo> fire;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class arrInfo {
        int r;
        int c;
        int cnt;

        public arrInfo(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        checkFire = new boolean[R][C];
        checkJihun = new boolean[R][C];

        jihun = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'J') {
                    jihun.add(new arrInfo(i, j, 1));
                    checkJihun[i][j] = true;
                } else if (arr[i][j] == 'F') {
                    fire.add(new arrInfo(i, j, 0));
                    checkFire[i][j] = true;
                }
            }
        }
        res = 0;
        bfs();
        if(res == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(res);
    }

    static void bfs() {
        while (!jihun.isEmpty()) {
            int size = fire.size();

            // 불이 여러개 일 수 있으니
            for (int i = 0; i < size; i++) {
                arrInfo info = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    if (nr >= 0 && nc >= 0 && nr < R && nc < C && arr[nr][nc] != '#' && !checkFire[nr][nc]) {
                        arr[nr][nc] = 'F';
                        checkFire[nr][nc] = true;
                        fire.offer(new arrInfo(nr, nc, 0));
                    }
                }
            }
            size = jihun.size();

            for (int i = 0; i < size; i++) {
                arrInfo info = jihun.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C){
                        res = info.cnt;
                        info.cnt++;
                        return;
                    }
                    if(arr[nr][nc] == '.' && !checkJihun[nr][nc] && !checkFire[nr][nc]){
                        arr[nr][nc] = 'J';
                        jihun.add(new arrInfo(nr, nc, info.cnt+1));
                    }
                }
            }
        }
    }// bfs
}