import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int H = sc.nextInt();

        int[] arr = new int[H+1];
        int[] reverse = new int[H+1];

        for(int i = 0 ; i < N/2 ; i++){
           arr[sc.nextInt()]++;
           reverse[sc.nextInt()]++;
        }

        int[] sumArr = new int[H+1];
        int[] sumReverse = new int[H+1];

        for(int i = 1 ; i<= H; i++){
            sumArr[i] =  sumArr[i-1] + arr[i];
            sumReverse[i] = sumReverse[i-1] + reverse[i];
        }

        int min = Integer.MAX_VALUE;
        int minSection = 0;

        for(int i = 1 ; i <= H ; i++){
            int colidCount = sumArr[H]- sumArr[i-1]  + sumReverse[H] - sumReverse[H-i];
            if(colidCount < min){
                min = colidCount;
                minSection = 1;
            }else if (colidCount == min){
                minSection++;
            }
        }
        System.out.println(min +" "+ minSection);
    }
}