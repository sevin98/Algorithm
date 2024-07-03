import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getLength(arr));
    }
    static int getLength(int[] arr){
        int N = arr.length;
        int[] dp = new int[N];

        Arrays.fill(dp , 1);

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
        max = Math.max(max, dp[i]);
        }
        return max;
    }

}