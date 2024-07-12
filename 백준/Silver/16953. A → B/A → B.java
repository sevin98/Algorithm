import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int cnt = 1;

        while(A!=B){
            if(B<A) {
                cnt = -1;
                break;
            }
            if(B % 10 == 1) B/=10;
            else if(B % 2 == 0) B/=2;
            else {
                cnt = -1;
                break;
            }

            cnt++;
        }
        System.out.println(cnt);
    }
}