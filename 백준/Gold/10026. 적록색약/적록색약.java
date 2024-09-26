import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] check;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }// arr

        int areaCnt = 0;
        int redAreaCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    bfs(i, j, arr[i][j]);
                    areaCnt++;
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            Arrays.fill(check[i], false);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    bfs(i, j, arr[i][j]);
                    redAreaCnt++;
                }
            }
        }
        System.out.println(areaCnt + " " + redAreaCnt);
    }

    static void bfs(int row, int col, char color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        check[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = dr[d] + r;
                int nc = c + dc[d];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !check[nr][nc] && arr[nr][nc] == color) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                }
            }
        }
    }
}