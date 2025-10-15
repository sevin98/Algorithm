import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N; i++){
            String book = br.readLine();
            if(map.containsKey(book)){
                map.put(book, map.get(book)+1);
            }else{
                map.put(book, 1);
            }
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2)-> {
            int a = map.get(o1);
            int b = map.get(o2);

            if( a!= b){
                return b-a;
            }

            return o1.compareTo(o2);
        });
        System.out.println(list.get(0));
    }
}
