import java.util.*;

public class Main {

    static int w, h, cnt;
    static int[][] arr;
    static boolean[][] check;
    static int[] dr ={-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    static class Node {
        int y;
        int x;

        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) break;

            cnt = 0;

            arr = new int[h][w];
            check = new boolean[h][w];

            for(int i = 0; i < h; i++) {
                for(int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            bfs();
            System.out.println(cnt);
        }
    }//main

    static void bfs() {
        for(int i = 0 ; i < h; i++){
            for(int j = 0 ; j < w; j++){
                if(arr[i][j] != 1 || check[i][j])continue;

                Queue<Node> q = new LinkedList<>();
                check[i][j] = true;
                q.add(new Node(i, j));
                while(!q.isEmpty()){
                    Node cur = q.poll();
                    for(int d = 0 ; d < 8; d++){
                        int nc = dc[d] + cur.y;
                        int nr = dr[d] + cur.x;

                        if(nr >= w || nc >= h || nr < 0 || nc < 0) continue;
                        if(arr[nc][nr] == 0 || check[nc][nr]) continue;

                        check[nc][nr] = true;
                        q.add(new Node(nc, nr));
                    }
                }
                cnt++;
            }
        }
    }//bfs
}