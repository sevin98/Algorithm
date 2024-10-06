import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static boolean[] check, done; // 1번 방문 check, 2번 방문 done;
    static int T, N, res;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N+1];
            check = new boolean[N+1];
            done = new boolean[N+1];
            res = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <= N; i++){
                if(done[i]) continue;
                dfs(i);
            }
            System.out.println(N - res);
        }//tc
    }//main
    static void dfs(int index){
        if(done[index]) return; // 해당원소에 두번 방문하면 다시 할 필요 없음
        if(check[index]){// 한번 방문했다면 done 으로 변경하고 팀 구성한 인원수 추가
            done[index] = true;
            res++;
        }
        check[index] = true;
        dfs(arr[index]);
        done[index] = true;
        check[index] = false;        
    }
}