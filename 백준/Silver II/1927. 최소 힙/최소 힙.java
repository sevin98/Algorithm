import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // N입력
		PriorityQueue<Integer> pq = new PriorityQueue<>(); // pq로 입력받으면서 자동정렬
		for (int i = 0; i < N; i++) {
			int input = Integer.parseInt(br.readLine());
			if (input == 0) { // pq에 입력값이 0일때
				if (pq.isEmpty()) { // pq가 비어있다면
					System.out.println(0); // 0출력
				} else { // pq 가 안비어있다면
					System.out.println(pq.poll()); // pq poll 하면서 출력
				}
			} else {
				pq.offer(input); // pq값이 0이 아닐때 해당 입력값 offer

			}
		}

	}
}
