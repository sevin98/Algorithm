import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static boolean[][] check;
    static int T, N, startR, startC, DestinationR, DestinationC;
    static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {

            N = sc.nextInt();
            check = new boolean[N][N];

            startR = sc.nextInt();
            startC = sc.nextInt();

            DestinationR = sc.nextInt();
            DestinationC = sc.nextInt();

            int res = bfs(startR, startC);
            System.out.println(res);
        }
    }

    static int bfs(int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        check[row][col] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                if (r == DestinationR && c == DestinationC) {
                    return cnt;
                }

                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N || check[nr][nc]) continue;

                    q.add(new int[]{nr, nc});
                    check[nr][nc] = true;
                }
            }
            cnt++;
        }
        return -1;
    }
}