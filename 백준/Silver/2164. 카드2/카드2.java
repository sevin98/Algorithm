import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> q =new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++)
            q.offer(i);

        int cnt = N;
        while(cnt -- > 1){
            q.poll();
            q.offer(q.poll());
        }
        System.out.println(q.poll());
    }
}