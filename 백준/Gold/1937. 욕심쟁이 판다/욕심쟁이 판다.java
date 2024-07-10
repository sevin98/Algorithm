import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int[][] dp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }//배열
        int cnt = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                cnt = Math.max(cnt, dfs(r,c));
            }
        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }//main

    static int dfs(int row, int col){
        if(dp[row][col] != 0) return dp[row][col];//기저

        //무조건 한 칸은 가니까 최솟값 한 칸 저장
        dp[row][col] = 1;

        for(int d= 0 ;d < 4; d++){
            int nr = row + dr[d];
            int nc = col + dc[d];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(arr[nr][nc] <= arr[row][col]) continue;

            dp[row][col] = Math.max(dp[row][col], dfs(nr,nc) + 1);

        }
        return dp[row][col];
    }
}