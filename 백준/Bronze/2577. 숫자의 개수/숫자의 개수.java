import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int num = A * B * C;

        int[] arr = new int[10];

        while (num > 0) {
            int temp = num % 10;
            arr[temp]++;
            num = num / 10;

        }
        for (int i = 0; i < 10; i++) {
            System.out.println(arr[i]);
        }
    }
}