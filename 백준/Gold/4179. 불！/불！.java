import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, res;
    static char[][] arr;
    static boolean[][] checkPerson;
    static boolean[][] checkFire;
    static Queue<Info> person;
    static Queue<Info> fire;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static class Info{
        int r, c, cnt;
        Info(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        checkPerson = new boolean[R][C];
        checkFire = new boolean[R][C];

        person = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'J') {
                    person.offer(new Info(i, j, 1));
                    checkPerson[i][j] = true;
                }

                else if(arr[i][j] == 'F') {
                    fire.offer(new Info(i, j, 0));
                    checkFire[i][j] = true;
                }
            }
        }
        res = 0;
        bfs();
        if(res == 0){
            sb.append("IMPOSSIBLE").append("\n");
        }else sb.append(res).append("\n");

        System.out.print(sb.toString());
    }//main

    static void bfs(){
        while(!person.isEmpty()){
            int size = fire.size();

            for(int i = 0 ; i < size; i++){
                Info info = fire.poll();

                for(int d= 0 ; d <4; d++){
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    if(nr < 0  || nc < 0 || nr >= R || nc >= C ) continue;
                    if(arr[nr][nc] != '#' && !checkFire[nr][nc]) {
                        arr[nr][nc] = 'F';
                        checkFire[nr][nc] = true;
                        fire.offer(new Info(nr, nc, 0));

                    }
                }
            }
            size = person.size();

            for(int i = 0 ; i < size; i++){
                Info info = person.poll();
                for(int d= 0 ; d <4; d++){
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    if(nr < 0  || nc < 0 || nr >= R || nc >= C) {
                        res = info.cnt++;
                        return;
                    }

                    if(arr[nr][nc] == '.'&& !checkPerson[nr][nc] && !checkFire[nr][nc]){
                        arr[nr][nc] = 'J';
                        person.offer(new Info(nr, nc, info.cnt+1));

                    }
                }
            }
        }
    }//bfs
}