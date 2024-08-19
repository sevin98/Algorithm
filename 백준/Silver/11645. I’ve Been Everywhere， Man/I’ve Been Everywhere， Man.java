import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
        HashSet<String> set = new HashSet<>();
            int N = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < N; i++) {
                set.add(sc.nextLine());
            }
            sb.append(set.size()).append("\n");
        }
        System.out.println(sb);
    }
}