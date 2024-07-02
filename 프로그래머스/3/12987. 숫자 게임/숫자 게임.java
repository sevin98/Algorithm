import java.util.Arrays;
class Solution {
	public static int solution(int[] A, int[] B) {
		int cnt = 0 ;
		
		Arrays.sort(A);
		Arrays.sort(B);
 
		int length = A.length-1; 
		int idx = length; 
		for(int i = length; i >= 0; i--) {
			if(A[i] < B[idx]) {
				cnt++; idx--;
			}
		}
	
		return cnt;
	}
}