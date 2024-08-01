/*
시간제한 2초
N,M 500,000   NM 250,000,000
완탐하면 시간초과임
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        int K = sc.nextInt();
        int[][] star = new int[K][2];
        int res = 0;
        for(int i = 0; i < K; i++){
            star[i][0] = sc.nextInt();
            star[i][1] = sc.nextInt();
        }
        for(int i = 0 ; i < K; i++){
            for(int j= 0 ; j < K; j++){
                int x  = star[i][0];
                int y  = star[j][1];
                int cnt = 0 ;
                for(int[] point : star){
                    if(x <= point[0] && x+L >= point[0] &&  y  <= point[1] && y + L >= point[1]) cnt++;
                }
                res = Math.max(res, cnt);
            }
        }
        System.out.println(K-res);
    }
}