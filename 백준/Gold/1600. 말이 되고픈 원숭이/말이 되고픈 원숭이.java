import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int K, W, H;
    static int[][] arr;
    static boolean[][][] check;
    static int[] dr ={-1,1,0,0};
    static int[] dc ={0,0,-1,1};
    static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Monkey{
        int r,  c,  cnt, hCnt;

        public Monkey(int r, int c, int cnt, int hCnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.hCnt = hCnt;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        arr = new int[H][W];
        check = new boolean[H][W][K+1];

        for(int r = 0 ; r< H; r++){
            for(int c = 0 ; c< W; c++){
                arr[r][c] = sc.nextInt();
            }
        }
        int res= bfs(0,0,K);
        System.out.println(res);
    }//main

    static int bfs(int row, int col, int limit){
        Queue<Monkey> q = new LinkedList<>();
        q.offer(new Monkey(row, col, 0, 0));
        while(!q.isEmpty()){
            Monkey m = q.poll();
            int curRow = m.r;
            int curCol = m.c;

            if(curRow == H-1 && curCol == W-1){
                return m.cnt;
            }
            //원숭이부터
            for (int d = 0 ;d < 4; d++){
                int nr = curRow + dr[d];
                int nc = curCol + dc[d];

                if(nr >= H || nc >= W || nc < 0 || nr <0) continue;
                if(check[nr][nc][m.hCnt]) continue;
                if(arr[nr][nc] == 0) {
                    q.add(new Monkey(nr, nc, m.cnt + 1, m.hCnt));
                    check[nr][nc][m.hCnt] = true;
                }
            }
            //말
            if(m.hCnt < K) {
                for (int d = 0; d < 8; d++) {
                    int nr = curRow + hdr[d];
                    int nc = curCol + hdc[d];
                    if (nr >= H || nc >= W || nc < 0 || nr < 0) continue;
                    if (check[nr][nc][m.hCnt+1]) continue;

                    if(arr[nr][nc] == 0) {
                        q.add(new Monkey(nr, nc, m.cnt + 1, m.hCnt + 1));
                        check[nr][nc][m.hCnt+1] = true;
                    }
                }
            }
        }
        return -1;
    }//bfs
}
