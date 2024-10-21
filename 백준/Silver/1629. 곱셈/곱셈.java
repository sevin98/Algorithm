import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int A, B, C;
    static long sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        System.out.println(recur(B));
    }

    static long recur(long B) {

        if(B == 1)
            return A % C;

        // 지수를 반으로 나누어 a^(b/2) 의 값을 한 번 구한뒤 해당 값을 두번 곱해주면 된다.
        // a^(b/2) 의 값을 또 반으로 나누어 a^((b/2)/2) 의 값을 구한 뒤 또 두번 곱해주면 된다
        // 이 과정을 b(지수) 가 1이 될 때 까지 반복한다.
        // 지수가 홀수일 때는 ex)9 a^4 * a^4 * a 이런식으로 표현해주면 된다.
        // 모듈러 합동 공식 이용
        // (A*B) % C = (a % C * B % C) % C
        sum = recur(B / 2);
        if(B % 2 == 1)
            return (sum * sum % C) * A % C;
        else
            return sum * sum % C;

    }
}