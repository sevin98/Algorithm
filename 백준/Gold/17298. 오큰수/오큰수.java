import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[N];
        int[] res = new int[N];
        StringBuilder sb= new StringBuilder();

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i <N; i++){
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                res[stack.pop()]= arr[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            res[stack.pop()]= -1;
        }
        for(int i = 0 ; i < N; i++){
            sb.append(res[i]+" ");
        }
        System.out.println(sb);
    }
}