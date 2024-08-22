import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] set = new int[10];

        int num = sc.nextInt();

        while (num > 0) {
            int temp = num % 10;
            set[temp]++;
            num = num / 10;
        }

        while (Math.abs(set[6] - set[9]) > 1) {
            if (set[6] > set[9] + 1) {
                set[6]--;
                set[9]++;
            }
            if (set[6] + 1 < set[9]) {
                set[6]++;
                set[9]--;
            }
        }
        int max = 0 ;
        for(int i = 0 ; i < 10 ; i++){
            max = Math.max(max, set[i]);
        }
        System.out.println(max);

    }
}