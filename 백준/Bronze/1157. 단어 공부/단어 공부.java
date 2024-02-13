import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26]; //알파벳 26개
		String str = br.readLine();
		
		for(int i =0 ; i< str.length(); i++) {
			if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
				arr[str.charAt(i) - 97]++;
			}else {
				arr[str.charAt(i)-65]++;
			}
		}int max = Integer.MIN_VALUE;
		char ch = '?';
		for(int i = 0; i< 26 ; i++) {
			
			if(arr[i] > max) {
				max = arr[i];
				ch = (char)(i+65);
			}
			else if(arr[i] == max){
				ch = '?';
			}
		}System.out.println(ch);
	}
}
