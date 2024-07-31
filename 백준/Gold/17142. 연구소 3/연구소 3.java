/*
인체에 치명적인 바이러스를 연구하던 연구소에 승원이가 침입했고, 바이러스를 유출하려고 한다. 바이러스는 활성 상태와 비활성 상태가 있다. 가장 처음에 모든 바이러스는 비활성 상태이고, 활성 상태인 바이러스는 상하좌우로 인접한 모든 빈 칸으로 동시에 복제되며, 1초가 걸린다. 승원이는 연구소의 바이러스 M개를 활성 상태로 변경하려고 한다.

연구소는 크기가 N×N인 정사각형으로 나타낼 수 있으며, 정사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽, 바이러스로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다. 활성 바이러스가 비활성 바이러스가 있는 칸으로 가면 비활성 바이러스가 활성으로 변한다.

예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자. 0은 빈 칸, 1은 벽, 2는 바이러스의 위치이다.

2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 2 0 1 1
0 1 0 0 0 0 0
2 1 0 0 0 0 2
M = 3이고, 바이러스를 아래와 같이 활성 상태로 변경한 경우 6초면 모든 칸에 바이러스를 퍼뜨릴 수 있다. 벽은 -, 비활성 바이러스는 *, 활성 바이러스는 0, 빈 칸은 바이러스가 퍼지는 시간으로 표시했다.

* 6 5 4 - - 2
5 6 - 3 - 0 1
4 - - 2 - 1 2
3 - 2 1 2 2 3
2 2 1 0 1 - -
1 - 2 1 2 3 4
0 - 3 2 3 4 *
시간이 최소가 되는 방법은 아래와 같고, 4초만에 모든 칸에 바이러스를 퍼뜨릴 수 있다.

0 1 2 3 - - 2
1 2 - 3 - 0 1
2 - - 2 - 1 2
3 - 2 1 2 2 3
3 2 1 0 1 - -
4 - 2 1 2 3 4
* - 3 2 3 4 *
연구소의 상태가 주어졌을 때, 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간을 구해보자.

입력
첫째 줄에 연구소의 크기 N(4 ≤ N ≤ 50), 놓을 수 있는 바이러스의 개수 M(1 ≤ M ≤ 10)이 주어진다.

둘째 줄부터 N개의 줄에 연구소의 상태가 주어진다. 0은 빈 칸, 1은 벽, 2는 비활성 바이러스의 위치이다. 2의 개수는 M보다 크거나 같고, 10보다 작거나 같은 자연수이다.

출력
연구소의 모든 빈 칸에 바이러스가 있게 되는 최소 시간을 출력한다. 바이러스를 어떻게 놓아도 모든 빈 칸에 바이러스를 퍼뜨릴 수 없는 경우에는 -1을 출력한다.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    static class Virus{
        int r, c;
        public Virus(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int N,M, min = Integer.MAX_VALUE, emptyCnt = 0;
    static int[][] arr;
    static boolean[] activeVirus;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Virus> virusList = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2)
                    virusList.add(new Virus(i,j));
                if(arr[i][j] ==0)emptyCnt++;
            }
        }
        activeVirus = new boolean[virusList.size()];

        if (emptyCnt == 0) {
            System.out.println(0);
        } else {
            dfs(0, 0);
            System.out.println((min == Integer.MAX_VALUE) ? -1 : min);
        }
    }

    static void dfs(int start, int depth){
        if(depth == M) {
            int[][] copy = copyMap();
            bfs(copy);
            return;
        }
        for (int i = start; i < virusList.size(); i++) {
            activeVirus[i] = true;
            dfs(i + 1, depth + 1);
            activeVirus[i] = false;
        }
    }

    static void bfs(int[][] copyArr){
        Queue<Virus> q = new LinkedList<>();
        boolean[][] check = new boolean[N][N];
        for(int i = 0 ; i < virusList.size() ; i++){
            if(activeVirus[i]) {
                Virus v = virusList.get(i);
                q.add(v);
                check[v.r][v.c] = true;
            }
        }
        int time = 0 ;
        int cnt = emptyCnt;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                Virus v = q.poll();
                for(int d = 0 ;d <4; d++){
                    int nr = v.r + dr[d];
                    int nc = v.c + dc[d];

                    if(canMove(nr, nc) && !check[nr][nc] && copyArr[nr][nc] != 1){
                        check[nr][nc] = true;
                        if(copyArr[nr][nc] == 0)
                           cnt--;

                    q.add(new Virus(nr,nc));
                }
            }
                }
            time++;
            if(cnt == 0){
                min = Math.min(min ,time);
                return;
            }
        }
    }

    static int[][] copyMap(){
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    static boolean canMove(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}