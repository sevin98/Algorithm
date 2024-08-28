import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            sb.append("#").append(tc).append(" ");

            int canDump = sc.nextInt();
            int[] arr = new int[100];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < canDump; i++) {
                int maxIdx = 0;
                int minIdx = 0;

                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > arr[maxIdx]) {
                        maxIdx = j;
                    }
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }

                arr[maxIdx]--;
                arr[minIdx]++;
            }

            int max = 0;
            int min = 100;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > max)
                    max = arr[j];
                if (arr[j] < min)
                    min = arr[j];
            }
            sb.append(max - min).append("\n");
        }
        System.out.println(sb);
    }
}