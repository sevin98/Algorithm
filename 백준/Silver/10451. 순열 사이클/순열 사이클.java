import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int T,N,cnt;
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();
        for(int tc= 1; tc<=T;tc++) {
            N = sc.nextInt();
            arr = new int[N+1];
            check = new boolean[N+1];
            cnt = 0;
            for(int i = 1; i <= N; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i = 1; i <= N; i++) {
                if(!check[i])
                    bfs(i);
            }
            System.out.println(cnt);
        }
    }//main

    static void bfs(int index){
        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        check[index] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(!check[arr[cur]]) {
                check[arr[cur]] = true;
                q.add(arr[cur]);
            }else{
                cnt++;
                break;
            }
        }
    }
}