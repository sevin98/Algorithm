import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 0;
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            dq.offer(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = dq.indexOf(Integer.parseInt(st.nextToken()));

            int half;
            if (dq.size() % 2 == 0) half = (dq.size() / 2) - 1;
            else half = (dq.size() / 2);

            if (target > half) {
                for (int j = 0; j < dq.size() - target; j++) {
                    dq.offerFirst(dq.pollLast());
                    cnt++;
                }
            } else {
                for (int j = 0; j < target; j++) {
                    dq.offerLast(dq.pollFirst());
                    cnt++;
                }
            }
            dq.pollFirst();
        }
        System.out.println(cnt);
    }
}