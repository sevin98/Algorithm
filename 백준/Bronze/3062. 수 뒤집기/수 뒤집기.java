import java.util.Scanner;

public class Main {
    static StringBuffer sbf;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String line = sc.nextLine();
            sbf = new StringBuffer(line);
            String reverse = sbf.reverse().toString();

            int num1 = Integer.parseInt(line);
            int num2 = Integer.parseInt(reverse);
            String needCheck = num1 + num2 + "";
            if (check(needCheck)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static boolean check(String line) {
        sbf = new StringBuffer(line);
        if (line.equals(sbf.reverse().toString())) return true;
        else return false;
    }
}