import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        int cnt = 0;

        for (int i = 1; i < 1001; i++) {
            for (int j = 0; j < i; j++) {
                if(cnt == 1000) break;
                list.add(i);
                cnt++;
            }
        }

        for(int i=start-1; i<=end-1; i++) {
            sum += list.get(i) ;
        }
        System.out.println(sum);
    }

}