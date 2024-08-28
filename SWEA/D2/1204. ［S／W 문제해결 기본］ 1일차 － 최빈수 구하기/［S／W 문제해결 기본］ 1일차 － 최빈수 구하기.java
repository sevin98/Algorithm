import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            int value = sc.nextInt();
            sb.append("#" + value + " ");
            int[] arr = new int[101];

            for (int i = 0; i < 1000; i++) {
                int num = sc.nextInt();
                arr[num]++;
            }
            int max = 0;
            int number = 0;

            for (int i = 100; i >= 0; i--) {
                if (arr[i] > max) {
                    max = arr[i];
                    number = i;
                } else if (arr[i] == max) {
                    if (i > number) {
                        number = i;
                    }
                }
            }
            sb.append(number).append("\n");
        }
        System.out.println(sb);
    }
}