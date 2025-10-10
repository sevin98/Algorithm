import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            double value = Double.parseDouble(br.readLine());
            if (pq.size() < 7) {
                pq.offer(value);
            } else if (pq.peek() > value) {
                    pq.poll();
                    pq.offer(value);
            }
        }
        double[] arr = new double[7];
        int idx = 6;

        while(!pq.isEmpty()) {
            arr[idx--] = pq.poll();
        }
        for (int i = 0; i < 7; i++) {
            System.out.printf("%.3f", arr[i]);
            System.out.println();
        }
    }
}
