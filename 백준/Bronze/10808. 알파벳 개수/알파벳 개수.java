import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alphabet = new int[26];

        String line = sc.nextLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if(c >= 'a' && c <= 'z'){
                int position = c-'a';
                alphabet[position]++;
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
        }
    }
}