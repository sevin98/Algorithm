import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1; // 후보의 수 N -1 (다솜)
        int cnt = 0; // 매수하는 사람 숫자
        int dasom = Integer.parseInt(br.readLine()); // 다솜이
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 기호 1번은 무조건 다솜이
        for (int i = 0; i < N; i++) {
            // 다솜이 다음부터
            pq.offer(Integer.parseInt(br.readLine()));
        }
        while (!pq.isEmpty() && pq.peek() >= dasom) {
            dasom++; // 다솜이 한표 올리기
            pq.offer(pq.poll() - 1); // 제일 큰 수에서 하나 빼서 다시 넣기
            cnt++;
        }
        System.out.println(cnt);
    }
}
