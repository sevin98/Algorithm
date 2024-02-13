//package boj1715;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//그냥 queue 에서 
		// PriorityQueue로
		PriorityQueue<Long> queue = new PriorityQueue<>();
// N 범위 최대 100,000 
		//int 에서 long
		for (long i = 0; i < N; i++) {
			queue.add(sc.nextLong());
		}
		long num = 0;

		while (queue.size() > 1) {
			long temp = queue.poll();
			long temp2 = queue.poll();

			num += temp + temp2;
			queue.add(temp + temp2);
		}
		System.out.println(num);
	}
}
