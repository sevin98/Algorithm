import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for(int i = 0 ; i < N; i++){
            list.add(br.readLine());
        }
        /**
         * A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
         * 만약 서로 길이가 같다면,
         * A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
         * 만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
         */
        list.sort((o1, o2) -> {
            if(o1.length() != o2.length()) return o1.length() - o2.length();
            else{
                // 같다면
                int sum1 = 0;
                int sum2 = 0;
                for(int i = 0 ; i< o1.length(); i++){
                    int num1 = o1.charAt(i) - '0';
                    int num2 = o2.charAt(i) - '0';
                    if( num1 > 0 && num1 < 10 ) {
                        sum1 += num1;
                    }
                    if( num2 > 0 && num2 < 10) {
                        sum2 += num2;
                    }
                }
                if( sum1 == sum2 ){
                    return o1.compareToIgnoreCase(o2);
                }
                return sum1 - sum2;
            }
        });
        list.forEach(System.out::println);
    }
}
