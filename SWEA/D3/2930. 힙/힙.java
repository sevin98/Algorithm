import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#" + tc + " ");
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                if(x == 1)
                    pq.add(sc.nextInt());
                else if(x == 2){
                    if(pq.isEmpty()) sb.append(-1 + " ");
                    else sb.append(pq.poll()+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}