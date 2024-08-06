import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int L, R, C;
    static char[][][] building;
    static int[] dr = {-1, 1, 0, 0, 0, 0};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            L = sc.nextInt();
            R = sc.nextInt();
            C = sc.nextInt();
            sc.nextLine();
            if (L == 0 & R == 0 & C == 0) {
                System.out.println(sb);
                return;
            }

            building = new char[L][R][C];

            int SR = 0;
            int SC = 0;
            int SZ = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = sc.nextLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k] == 'S') {
                            SR = k;
                            SC = j;
                            SZ = i;
                            building[i][j][k] = '.';
                        }
                    }
                }
                sc.nextLine();
            }
            bfs(SR, SC, SZ);
        }
    }

    static void bfs(int r, int c, int z) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] check = new boolean[L][R][C];
        q.add(new int[]{r, c, z, 0});
        check[z][c][r] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int pr = cur[0];
            int pc = cur[1];
            int pz = cur[2];
            int move = cur[3];
            if (building[pz][pc][pr] == 'E') {
                sb.append("Escaped in " + move + " minute(s).").append("\n");
                return;
            }
            for (int d = 0; d < 6; d++) {
                int nr = pr + dr[d];
                int nc = pc + dc[d];
                int nz = pz + dz[d];

                if (nr < 0 || nc < 0 || nz < 0 || nr > C - 1 || nc > R - 1 || nz > L - 1) continue;
                if (check[nz][nc][nr]) continue;
                if (building[nz][nc][nr] == 'E' || building[nz][nc][nr] == '.') {
                    check[nz][nc][nr] = true;
                    q.add(new int[]{nr, nc, nz, move + 1});
                }
            }
        }
        sb.append("Trapped!").append("\n");
    }
}