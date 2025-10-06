import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 버퍼의 크기 N
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> router = new LinkedList<>();
        while(true){
            int intelligence = Integer.parseInt(br.readLine());

            // 기저조건
            if(intelligence == -1){
                break;
            }

            if(intelligence > 0){
                router.offer(intelligence);
            }else if(intelligence == 0){
                router.poll();
            }
        }
        for(int intelligence : router){
            System.out.print(intelligence + " ");
        }
    }
}
