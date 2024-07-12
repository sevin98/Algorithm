import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N,M,size;
    static int[] arr, prtArr;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr= new int[N];
        prtArr = new int[N];
        check = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth){
        if(depth == M){
            for(int i= 0 ; i < M; i++){
                sb.append(prtArr[i]+" ");
            }
            sb.append("\n");
            return;
        }

        int before = -1;
        for(int i = 0; i < arr.length; i++){
            int curr = arr[i];
            if(check[i] || before == curr) continue;
            else{
                before = curr;
                check[i] = true;
                prtArr[depth] = arr[i];
                dfs(depth+1);
                check[i] = false;
            }
        }
    }
}