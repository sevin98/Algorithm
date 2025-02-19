import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] check;
    static int N, M, cnt, result;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        check = new boolean[5][5];
        StringTokenizer st;
        for (int r = 0; r < 5; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < 5; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        result = 0;
        check[N][M] = true;

        dfs(N, M, 0);

        System.out.println(result);
    }

    static void dfs(int r, int c, int depth) {
        if (depth > 3) return;

        boolean eat = false;
        if (arr[r][c] == 1) {
            cnt++;
            arr[r][c] = 0; 
            eat = true;
        }

        if (cnt >= 2) {
            result = 1;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !check[nr][nc] && arr[nr][nc] != -1) {
                check[nr][nc] = true;
                dfs(nr, nc, depth + 1);
                check[nr][nc] = false;

                if (result == 1) return; 
            }
        }

        if (eat) {
            arr[r][c] = 1;
            cnt--;
        }
    }
}