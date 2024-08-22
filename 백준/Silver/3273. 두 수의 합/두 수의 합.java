import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1_000_000;
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int cnt = 0;
        int left = 0;
        int right = N - 1;

        int X = sc.nextInt();
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == X) {
                cnt++;
                left++;
                right--;
            }
            else if(sum > X) {
                right--;
            }
            else
                left++;
        }
        System.out.println(cnt);
    }
}