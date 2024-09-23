import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static boolean[][] check;
    static int N, M, cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int ii = 0; ii < M; ii++) {
                arr[i][ii] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        int pictureCnt = 0;

        for (int i = 0; i < N; i++) {
            for (int ii = 0; ii < M; ii++) {
                if (arr[i][ii] == 1 && !check[i][ii]) {
                    pictureCnt++;
                    max = Math.max(bfs(i, ii), max);
                }
            }
        }
        System.out.println(pictureCnt);
        System.out.println(max);
    }

    static int bfs(int row, int col) {
        cnt = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        check[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (canMove(nr, nc)) {
                    q.offer(new int[]{nr, nc});
                    check[nr][nc] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean canMove(int row, int col) {
        return row >= 0 && col >= 0 && row < N && col < M && arr[row][col] == 1 && !check[row][col];
    }
}