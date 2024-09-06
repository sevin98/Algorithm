import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        StringBuilder res = new StringBuilder();
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch(s){
                case "push" :
                    q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if(!q.isEmpty())
                      res.append(q.poll()).append("\n");
                    else res.append(-1).append("\n");
                    break;
                case "front" :
                    if(!q.isEmpty())
                        res.append(q.peek()).append("\n");
                    else res.append(-1).append("\n");
                    break;
                case "back" :
                    if(!q.isEmpty())
                        res.append(q.peekLast()).append("\n");
                    else res.append(-1).append("\n");
                    break;
                case "size" :
                    res.append(q.size()).append("\n");
                    break;
                case "empty" :
                    boolean check = q.isEmpty();
                    int num = 0;
                    if(check) num = 1;
                    res.append(num).append("\n");
                    break;
            }
        }
        System.out.println(res);
    }
}