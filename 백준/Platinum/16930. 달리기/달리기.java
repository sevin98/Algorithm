import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    /**
     * 진영이는 다이어트를 위해 N×M 크기의 체육관을 달리려고 한다. 체육관은 1×1 크기의 칸으로 나누어져 있고, 칸은 빈 칸 또는 벽이다. x행 y열에 있는 칸은 (x, y)로 나타낸다.
     * 매 초마다 진영이는 위, 아래, 오른쪽, 왼쪽 중에서 이동할 방향을 하나 고르고, 그 방향으로 최소 1개, 최대 K개의 빈 칸을 이동한다.
     * 시작점 (x1, y1)과 도착점 (x2, y2)가 주어졌을 때, 시작점에서 도착점으로 이동하는 최소 시간을 구해보자.
     * 첫째 줄에 체육관의 크기 N과 M, 1초에 이동할 수 있는 칸의 최대 개수 K가 주어진다.
     * 둘째 줄부터 N개의 줄에는 체육관의 상태가 주어진다. 체육관의 각 칸은 빈 칸 또는 벽이고, 빈 칸은 '.', 벽은 '#'으로 주어진다.
     * 마지막 줄에는 네 정수 x1, y1, x2, y2가 주어진다. 두 칸은 서로 다른 칸이고, 항상 빈 칸이다.
     * 출력
     * (x1, y1)에서 (x2, y2)로 이동하는 최소 시간을 출력한다. 이동할 수 없는 경우에는 -1을 출력한다.
     */
    static char[][] arr;
    static int[][] dist;
    static boolean[][] check;
    static int[] dr = { - 1, 1, 0, 0 };
    static int[] dc = { 0, 0, - 1, 1 };
    static int x1, y1, x2, y2;
    static int N, M, K;
    public static void main( String[] args ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[ N ][ M ];
        check = new boolean[ N ][ M ];
        dist = new int[ N ][ M ];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        for ( int r = 0; r < N; r++ ) {
            String line = br.readLine();
            for ( int c = 0; c < M; c++ ) {
                arr[ r ][ c ] = line.charAt(c);
            }
        }

        st = new StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken())-1;
        y1 = Integer.parseInt(st.nextToken())-1;
        x2 = Integer.parseInt(st.nextToken())-1;
        y2 = Integer.parseInt(st.nextToken())-1;

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x1, y1});
        dist[x1][y1] = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int step = dist[x][y];

            if (x == x2 && y == y2) {
                return step;
            }

            for (int d = 0; d < 4; d++) {
                for (int i = 1; i <= K; i++) {
                    int nx = x + dr[d] * i;
                    int ny = y + dc[d] * i;

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#') break;
                    if (dist[nx][ny] < step + 1) break;

                    if (dist[nx][ny] == Integer.MAX_VALUE) {
                        dist[nx][ny] = step + 1;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}
