import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;
    static ArrayList<Integer>[] friend; // 그래프를 표현하기위해 ArrayList들의 배열로 선언
    static int res;
    static int[] result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        friend = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            friend[i] = new ArrayList<>();
            // 모든 노드마다 ArrayList 로 그래프 표현
        }

        // 모든 노드 마다 그래프에 달아주기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            friend[x].add(y);
            friend[y].add(x);
            // 서로 이어지게 연결해주기
        }
        // 결과값 배열
        result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                res = Integer.MAX_VALUE;
                check = new boolean[N+1];
                if(i != j){
                    dfs(i,j,0);
                    result[i] += res;
                }
            }
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i =1 ; i <= N; i++){
            if(min > result[i]){
                min = result[i];
                index = i;
            }
        }
        System.out.println(index);

    }//main

    static void dfs(int start, int end, int depth) {
        if (start == end) {
            res = Math.min(res, depth);
            return;
        }

        check[start] = true;
        for (int num : friend[start]) {
            if (!check[num]) {
                dfs(num, end, depth + 1);
            }
        }
    }
}