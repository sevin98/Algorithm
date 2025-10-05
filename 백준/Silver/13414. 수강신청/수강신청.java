import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

       String[]  arr = new String[N];

       for(int i = 0 ; i < N; i++){
           arr[i] = br.readLine();
       }

       LinkedHashSet<String> set = new LinkedHashSet<>();

       for(String s : arr){
           if(set.contains(s)){
               set.remove(s);
           }
           set.add(s);
       }
       int cnt = 0 ;
       for(String s : set){
           cnt++;
           System.out.println(s);
           if(cnt == M) break;
       }
    }
}
