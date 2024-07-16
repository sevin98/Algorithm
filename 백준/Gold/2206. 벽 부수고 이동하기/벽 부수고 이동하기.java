import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};


    static class Node{
        int x, y, cnt;
        boolean isDestroy;

        public Node(int x, int y, int cnt, boolean isDestroy) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.isDestroy = isDestroy;
        }
    }
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];
        sc.nextLine();
        for(int r = 0 ; r < N ; r++) {
            String line = sc.nextLine();
            for(int c = 0 ; c < M ; c++) {
                arr[r][c] = line.charAt(c)-'0';
            }
        }
        bfs();
    }//main

    static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));
        //N,과M좌표의 벽을 부신 여부를 확인하는 3차원check배열
        boolean[][][] check = new boolean[N][M][2];

        while(!q.isEmpty()) {
            Node cur = q.poll();
            int nowR = cur.x;
            int nowC = cur.y;

            if(nowR == N-1 && nowC == M-1) {
                System.out.println(cur.cnt);
                return;
            }

            for(int d = 0 ; d <  4; d++){
                int nr = nowR + dr[d];
                int nc = nowC + dc[d];

                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if(arr[nr][nc] == 0){
                    if(!cur.isDestroy && !check[nr][nc][0]){
//                        System.out.println(arr[nr][nc]);
                        q.offer(new Node(nr, nc, cur.cnt+1, false));
                        check[nr][nc][0] = true;
                    }else if(cur.isDestroy && !check[nr][nc][1]){
//                        System.out.println(arr[nr][nc]);
                        q.offer(new Node(nr, nc, cur.cnt+1, true));
                        check[nr][nc][1] = true;
                    }
                }else if(arr[nr][nc] == 1){
                    if(!cur.isDestroy){
//                        System.out.println(arr[nr][nc]);
                        q.offer(new Node(nr, nc, cur.cnt+1, true));
                        check[nr][nc][1] = true;
                    }
                }
            }
        }
        System.out.println(-1);
    }

}