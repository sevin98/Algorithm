import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int R, C, max;
    static boolean[] alphabetCheck;
    static int[][] arr;
    static boolean[][] check;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        arr = new int[R][C];
        check = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            String line = sc.nextLine();
            for (int c = 0; c < C; c++) {
                arr[r][c] = line.charAt(c) - 'A';
            }
        }
        max = 0;
        alphabetCheck = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int row, int col, int len) {
        alphabetCheck[arr[row][col]] = true;
        max = Math.max(max, len);

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !alphabetCheck[arr[nr][nc]]) {
                    dfs(nr, nc, len + 1);
                    alphabetCheck[arr[nr][nc]] = false;
            }
        }
    }
}