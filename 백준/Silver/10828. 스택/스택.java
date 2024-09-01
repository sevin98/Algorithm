import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            String mission = sc.next();
            switch (mission) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "top":
                    if (stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.peek()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "pop":
                    if (stack.isEmpty())
                        sb.append(-1).append("\n");
                    else
                        sb.append(stack.pop()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty())
                        sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
            }
            sc.nextLine();
        }
        System.out.println(sb);
    }
}