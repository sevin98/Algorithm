//package 백준11003_최솟값찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		Deque<Integer> dq = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			//arr[덱의첫값] 이 arr[i] 보다 크면 마지막값을 제외
			//현재 인덱스 보다 큰 값 제외
			while(!dq.isEmpty() && arr[dq.peekLast()] >= arr[i])
				//처음 제외되는 수 5
				dq.pollLast();
			//구간의 길이보다 큰 수는 제외 
			if(!dq.isEmpty() && dq.peekFirst() <= i-L)
				dq.pollFirst();
			//첫번쨰 i 는 무조건 들어감.
			dq.offerLast(i);
//			System.out.print(dq.peekFirst()+" ");
			//arr[0] 출력으로 시작
			sb.append(arr[dq.peekFirst()]).append(" ");
		}
		System.out.println(sb);
	}
	
}
