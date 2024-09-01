import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (K-- > 0) {
            int num = sc.nextInt();
            switch (num) {
                case 0:
                    stack.pop();
                    break;
                default:
                    stack.push(num);
                    break;
            }
            sc.nextLine();
        }
        int sum = 0;

        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);

    }
}