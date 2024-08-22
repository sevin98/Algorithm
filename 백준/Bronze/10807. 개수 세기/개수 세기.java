import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N= sc.nextInt();
        sc.nextLine();
        int[] arr =new int[N];

        for(int i=0;i<N;i++){
            arr[i]=sc.nextInt();
        }
        int number = sc.nextInt();
        int cnt = 0;
        for(int num : arr){
            if(num==number){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}