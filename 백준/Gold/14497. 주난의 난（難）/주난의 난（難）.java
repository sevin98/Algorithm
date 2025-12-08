import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int N, M;
    static boolean[][] visited;
    static char[][] arr;
    static int cnt;

    static int thiefX;
    static int thiefY;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());
        int junanX = Integer.parseInt(st.nextToken());
        int junanY = Integer.parseInt(st.nextToken());
        thiefX = Integer.parseInt(st.nextToken()) - 1;
        thiefY = Integer.parseInt(st.nextToken()) - 1;

        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < M; c++) {
                arr[r][c] = line.charAt(c);
            }
        }
        cnt = 0;
        int res = bfs(junanX -1, junanY -1);
        System.out.println(res);
    }

    static int bfs(int sx, int sy) {
        Queue<int[]> cur = new LinkedList<>();
        Queue<int[]> next = new LinkedList<>();

        cur.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int cnt = 0;

        while (true) {
            cnt++;

            while (!cur.isEmpty()) {
                int[] curr = cur.poll();
                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nr][nc]) continue;

                    if (arr[nr][nc] == '0' || arr[nr][nc] == '*') {
                        visited[nr][nc] = true;
                        cur.offer(new int[]{nr, nc});
                    } else if (arr[nr][nc] == '1') {
                        visited[nr][nc] = true;
                        next.offer(new int[]{nr, nc});
                    } else if (arr[nr][nc] == '#') {
                        return cnt;
                    }
                }
            }

            while (!next.isEmpty()) {
                int[] p = next.poll();
                int r = p[0];
                int c = p[1];
                arr[r][c] = '0';
                cur.offer(new int[]{r, c});
            }
        }
    }




    static void cleanCell(int row, int col) {
        arr[row][col] = '0';
    }

    static boolean wave(int row, int col) {
        if (!canVisit(row, col)) return false;

        if (row == thiefX && col == thiefY) return true;
        cleanCell(row, col);
        visited[row][col] = true;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            while (canVisit(nr, nc)) {

                if (nr == thiefX && nc == thiefY) return true;
                cleanCell(nr, nc);
                visited[nr][nc] = true;

                nr += dr[d];
                nc += dc[d];
            }
        }
        return false;
    }

    static boolean canVisit(int row, int col) {
        if (row < 0 || row >= N || col < 0 || col >= M) return false;
        if (visited[row][col]) return false;
        if (arr[row][col] == '1') return false;

        return true;
    }
}
