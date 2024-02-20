//package boj1929_소수구하기;

import java.util.Scanner;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.close();
		
		getPrime(N, M);
		System.out.println(sb);
	}

	public static void getPrime(int N, int M) {
		for (int i = N; i <= M; i++) { // N부터 M까지의 i중에
			if (isPrime(i)) { // isprime 이 true라면
				sb.append(i).append("\n"); //줄마다 입력
			}
			
		}
	}

	public static boolean isPrime(int num) {//소수인지 true false로 확인하는 함수
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
