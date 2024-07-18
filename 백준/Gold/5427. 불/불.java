import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main  {

    static int W, H, T, res;
    static char[][] arr;
    static boolean[][] check;
    static int[] dr={-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static Queue<info> person;
    static Queue<info> fire;

    static class info{
        int r, c, cnt;
        public info(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new char[H][W];
            check = new boolean[H][W];

            person = new LinkedList<>();
            fire = new LinkedList<>();
            for(int i = 0 ; i < H; i++){
                String line = br.readLine();
                for(int j = 0 ; j < W ; j++){
                    arr[i][j] = line.charAt(j);
                    if(arr[i][j] == '@') person.offer(new info(i, j, 0));
                    else if(arr[i][j] =='*') fire.offer(new info(i, j, 0));
                }
            }//arr

            res = 0;
            bfs();
            if(res == 0) sb.append("IMPOSSIBLE");
            else sb.append(res);
            sb.append("\n");
        }//tc
        System.out.println(sb);
    }//main
    static void bfs(){
        while(!person.isEmpty()){
            int size = fire.size();;

            for(int i = 0 ; i < size; i++) {
                info curr = fire.poll();
                for(int d = 0 ; d< 4; d++){
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    //arr안에서 불이 움직일 수 있는 구간이면 불이 번짐
                    if(canMove(nr,nc) && (arr[nr][nc] == '.'|| arr[nr][nc] == '@')){
                        arr[nr][nc] = '*';
                        fire.offer(new info(nr, nc, 0));
                    }
                }
            }
            size = person.size();
            for(int i = 0 ; i < size; i++) {
                info curr = person.poll();
                for(int d = 0 ; d< 4; d++){
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if(!canMove(nr,nc)){
                        res = curr.cnt+1;
                        return;
                    }
                    if(arr[nr][nc] == '.'){
                        arr[nr][nc] ='@';
                        person.offer(new info(nr, nc, curr.cnt+1));
                    }
                }
            }
        }
    }
    static boolean canMove(int r, int c){
        return r >= 0 && c >= 0 && r < H && c< W;
    }

}