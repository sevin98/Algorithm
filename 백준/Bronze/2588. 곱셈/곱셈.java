import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberA = Integer.parseInt(br.readLine());
        String numberB = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 2 ; i >= 0; i--){
            int num = numberB.charAt(i) - '0';
            sb.append(numberA * num).append("\n");
        }
        sb.append(numberA * Integer.parseInt(numberB));
        System.out.println(sb);
    }
}
