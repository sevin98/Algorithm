import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(lengthOfLIS(arr));
    }
    public static int lengthOfLIS(int[] arr){
        int[] res = new int[arr.length];
        int length = 0;

        res[length++] = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > res[length-1]) {
                res[length++] = arr[i];
            }else{
                int pos = binarySearch(res, 0, length-1, arr[i]);
                res[pos] = arr[i];
            }
        }
        return length;
    }
    static int binarySearch(int[] lis, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(lis[mid] < target){
                left = mid +1;
            }
            else{
                right = mid -1;
            }
        }
        return left;
    }
}