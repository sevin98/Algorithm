import java.util.*;

public class Main {

    static class Virus {
        int r, c;
        public Virus(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] arr;
    static boolean[] check;
    static int N, M, min = Integer.MAX_VALUE, emptyCount = 0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static List<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 2) virusList.add(new Virus(i, j));
                if (arr[i][j] == 0) emptyCount++;
            }
        }
        emptyCount += virusList.size() - M;
        check = new boolean[virusList.size()];

        if (emptyCount == 0) min = 0;
        else dfs(0, 0);

        System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
    }

    static int[][] copyMap() {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = (arr[i][j] == 2 ? 0 : arr[i][j]);
            }
        }
        for (int i = 0; i < virusList.size(); i++) {
            if (check[i]) {
                Virus virus = virusList.get(i);
                copy[virus.r][virus.c] = 2;
            }
        }
        return copy;
    }

    static void dfs(int start, int depth) {
        if (depth == M) {
            int[][] copy = copyMap();
            bfs(copy, emptyCount);
            return;
        }

        for (int i = start; i < virusList.size(); i++) {
            check[i] = true;
            dfs(i + 1, depth + 1);
            check[i] = false;
        }
    }

    private static void bfs(int[][] map, int cnt) {
        Queue<Virus> q = new LinkedList<>();
        for (int i = 0; i < virusList.size(); i++) {
            if (check[i]) q.add(virusList.get(i));
        }

        int time = 0;
        while (!q.isEmpty()) {
            if (min <= time) break;

            int size = q.size();
            for (int t = 0; t < size; t++) {
                Virus curr = q.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if (!canMove(nr, nc)) continue;
                    if (map[nr][nc] != 0) continue;

                    map[nr][nc] = 2;
                    q.add(new Virus(nr, nc));
                    cnt--;
                }
            }
            time++;
            if (cnt == 0) {
                min = Math.min(min, time);
                return;
            }
        }
    }

    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}