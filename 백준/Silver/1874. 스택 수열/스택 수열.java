import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int curr = 1;
        boolean possible = true;

        while (N-- > 0) {
            int num = sc.nextInt();

            while (curr <= num) {
                s.push(curr);
                sb.append("+\n");
                curr++;
            }

            if (!s.isEmpty() && s.peek() == num) {
                s.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }
        if (!possible)
            System.out.println("NO");
        else
            System.out.println(sb);
    }
}