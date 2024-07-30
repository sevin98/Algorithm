import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        long res = 0 ;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            int h = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= h){
                stack.pop();
            }
            stack.push(h);
            res += stack.size()-1;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}