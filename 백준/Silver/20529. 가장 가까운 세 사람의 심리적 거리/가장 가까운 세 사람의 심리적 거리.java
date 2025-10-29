import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] mbti;
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            mbti = new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(N > 32) {
                System.out.println(0);
                continue;
            }
            for(int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            for(int i = 0 ; i < N; i++){
                for(int j = i+1; j < N; j++){
                    for(int k = j+1; k < N; k++){
                        int cnt = dist(mbti[i],mbti[j], mbti[k]);
                        min = Math.min(min, cnt);
                    }
                }
            }
            System.out.println(min);
        }
    }
    static int dist(String a, String b, String c){
        char[] charArr1 = a.toCharArray();
        char[] charArr2 = b.toCharArray();
        char[] charArr3 = c.toCharArray();

        int cnt = 0 ;
        for(int i = 0 ; i < charArr1.length ; i++){
            if(charArr1[i] != charArr2[i]) cnt++;
            if(charArr2[i] != charArr3[i]) cnt++;
            if(charArr3[i] != charArr1[i]) cnt++;
        }
        return cnt;
    }
}
