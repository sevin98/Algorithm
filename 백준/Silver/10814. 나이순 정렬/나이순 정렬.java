//package boj10814_나이순정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 비교해야하는 값이 두개여서 HashMap사용해야할것같음
		// key값이 같다면 value값 출력
		// 근데 해쉬맵은 순서가 없음
		// 그럼 뭘써야함?
		// 2차원배열?
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arr = new String[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken(); // 나이입력
			arr[i][1] = st.nextToken(); // 이름입력
		}
		Arrays.sort(arr, Comparator.comparingInt(o -> Integer.parseInt(o[0])));
		//람다식으로 나이순 정렬
		//람다식 구글링으로 복습
		//foreeach문 ㅂ복습
		StringBuilder sb = new StringBuilder();
			for(String person[] : arr) {
				sb.append(person[0]).append(" ").append(person[1]).append("\n");
				//나이와 이름 출력
			}
			System.out.println(sb);
	}
}
