import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        StringBuilder sb = new StringBuilder();

        pointStar(0, 0, N, false);

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                sb.append(arr[r][c]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void pointStar(int r, int c, int N, boolean blank) {

        if (blank) {
            for (int i = r; i < r + N; i++) {
                for (int j = c; j < c + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (N == 1) {
            arr[r][c] = '*';
            return;
        }

        int size = N / 3;
        int cnt = 0;
        for (int i = r; i < r + N; i+=size) {
            for (int j = c; j < c + N; j+=size) {
                cnt++;
                if (cnt == 5) {
                    pointStar(i, j, size, true);
                } else {
                    pointStar(i, j, size, false);
                }
            }
        }
    }
}