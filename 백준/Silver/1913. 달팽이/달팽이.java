import java.util.Scanner;

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        solution1(N, target);
        solution2(N, target);
    }


    public static void solution1(int N, int target) {
        int value= N * N;
        int turn = N;
        int r = 0;
        int c = 0;
        int[][] arr = new int[N][N];
        int time = 0;

        while(value > 0){
            r = time;
            for(int i = c; i < turn; i++){
                arr[i][r] = value--;
            }
            c = turn-1;
            for(int i = r+1; i < turn; i++){
                arr[c][i] = value--;
            }
            r= turn-1;
            for(int i =c-1 ; i >= time; i--){
                arr[r][i] = value--;
            }
            c = time;
            for(int i = r-1; i> time; i--){
               arr[c][i] = value--;
            }
            time++;
            turn--;
            c = time;
        }
        sb= new StringBuilder();
        int nr = 0;
        int nc = 0 ;
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ;j < N; j++){
                if(arr[i][j] == target){
                    nr = i +1;
                    nc = j + 1;
                }
//                sb.append(arr[i][j] + " ");
            }
//            sb.append("\n");
        }
//        sb.append(nr + " " + nc);
//        System.out.println(sb);
    }

    private static void solution2(int N, int target) {

        int[][] arr = new int[N][N];
        int value = 1;
        int x = N/2;
        int y = N/2;
        int limit =1;
        while(true) {
            for(int i=0; i<limit; i++) {
                arr[y--][x] = value++;
            }
            if(value-1 == N*N) break;
            for(int i=0; i<limit; i++) {
                arr[y][x++] = value++;
            }

            limit++;
            for(int i=0; i<limit; i++) {
                arr[y++][x] = value++;
            }

            for(int i=0; i<limit; i++) {
                arr[y][x--] = value++;
            }
            limit++;
        }

        StringBuilder sb = new StringBuilder();
        int tx=0, ty=0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(target==arr[i][j]) {
                    ty=i+1;
                    tx=j+1;
                }
                sb.append(arr[i][j] +" ");
            }
            sb.append("\n");
        }
        sb.append(ty+" "+tx);
        System.out.println(sb);
    }
}
