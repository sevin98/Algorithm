import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<String, Integer> map = new HashMap<>();
    static int[] dr = {-1 ,1 ,0 ,0};
    static int[] dc = {0, 0, -1, 1};
    static String answer = "123456780";

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String temp = "";
        for(int i = 0 ; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < 3; j++){
                int tempNum = Integer.parseInt(st.nextToken());
                temp += tempNum;
            }
        }

        map.put(temp, 0);
        System.out.println(bfs(temp));
    }//main
    static int bfs(String temp){
        Queue<String> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            String s = q.poll();
            int move = map.get(s);
            int empty = s.indexOf('0');
            int cr = empty%3;
            int cc = empty/3;

            if(s.equals(answer)) return move;

            for(int d = 0 ; d <4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr >= 3 || nc >= 3 || nr < 0 || nc < 0) continue;

                int number = nc * 3 + nr;
                char c = s.charAt(number);
                String next = s.replace(c,'c');
                next = next.replace('0', c);
                next = next.replace('c', '0');

                if(!map.containsKey(next)) {
                    q.add(next);
                    map.put(next, move + 1);
                }
            }
        }
        return -1;
    }
}