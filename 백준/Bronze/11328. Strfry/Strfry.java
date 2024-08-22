import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb= new StringBuilder();
        while (T-- > 0) {
            String line1 = sc.next();
            String line2 = sc.next();

//            System.out.println("=========" + line1 + "=======" + line2);

            if(line1.length() != line2.length()) {
                sb.append("Impossible").append("\n");
                continue;
            }

            char[] c1 = line1.toCharArray();
            char[] c2 = line2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);

            if(Arrays.equals(c1,c2)){
                sb.append("Possible").append("\n");
            }else sb.append("Impossible").append("\n");
        }
        System.out.println(sb);
    }
}