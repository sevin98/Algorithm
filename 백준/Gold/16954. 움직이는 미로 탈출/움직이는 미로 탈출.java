import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static char[][] arr;
    static int[] dr={-1,-1,-1, 0, 1, 1, 1, 0, 0};
    static int[] dc={-1, 0, 1, 1, 1, 0, -1, -1, 0};


    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new char[8][8];

        for(int r = 0 ;r < 8 ;r++){
            String line = br.readLine();
            for(int c = 0 ;c < 8 ;c++){
                arr[r][c] = line.charAt(c);
            }
        }//배열
        boolean isPossible = bfs();

        int ans = isPossible ? 1 : 0 ;
        System.out.println(ans);

    }//main
    static boolean bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{7, 0});

        while(!q.isEmpty()){
            int size = q.size();
            boolean[][] check = new boolean[8][8];

            for(int i = 0 ; i < size; i++){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];

            if(arr[r][c] == '#') continue;
            if(r == 0 && c == 7) return true;

            for(int d = 0 ;d < 9; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= 8 || nc >= 8) continue;
                if (check[nr][nc] || arr[nr][nc] == '#') continue;
                //가려는 칸 한 칸 위의 칸이 벽이면(다음턴에 벽이 내려오기때문에 움직이지않는다)
                check[nr][nc] = true;
                q.add(new int[]{nr, nc});
                }
            }//이동 후엔 벽 움직이기
            moveWall();
        }//while

        return false;
    }//bfs
//벽이 캐릭터가 있는 칸으로 이동하면 더 이상 캐릭터는 이동할 수 없다.
    //욱제의 캐릭터는 1초에 인접한 한 칸 또는 대각선 방향으로 인접한 한 칸으로 이동하거나, 현재 위치에 서 있을 수 있다. 이동할 때는 빈 칸으로만 이동할 수 있다.

    static void moveWall(){
        for(int r = 7 ;r >= 0 ;r--){
            for(int c = 0 ;c < 8 ;c++){

                //배열 돌면서 벽이면 원래위치를 . 으로바꾸고
                //해당위치의 한 칸 아래를 벽으로 바꿈
                if(arr[r][c] == '#'){
                    arr[r][c] = '.';

                   if(r<7){
                       arr[r+1][c] = '#';
                   }
                }
            }
        }
    }//movewWall

}