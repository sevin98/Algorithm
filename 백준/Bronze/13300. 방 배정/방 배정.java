import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[][] student = new int[2][7];
        for (int i = 1; i <= N; i++) {
            int s = sc.nextInt();
            int y = sc.nextInt();
            student[s][y]++;
        }
        int sum = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 7; j++) {
                sum += student[i][j] / K;
                if (student[i][j] % K != 0) sum++;
            }
        }
        System.out.println(sum);
    }
}