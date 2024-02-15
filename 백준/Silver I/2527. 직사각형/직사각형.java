import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int tc = 0; tc < 4; tc++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int p1 = sc.nextInt();
            int q1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int p2 = sc.nextInt();
            int q2 = sc.nextInt();

            //
            if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                System.out.println("d");
            } 
            //포함
            else if ((x1 < x2 && y1 < y2 && p1 > p2 && q1 > q2) || 
                     (x2 < x1 && y2 < y1 && p2 > p1 && q2 > q1)) {
                System.out.println("a");
            } 
            //점
            else if ((p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2) || 
                     (x1 == p2 && q1 == y2) || (x1 == p2 && y1 == q2)) {
                System.out.println("c");
            } 
            //선분
            else if (p1 == x2 || p2 == x1 || q1 == y2 || q2 == y1) {
                System.out.println("b");
            } 
            // 그 외의 경우
            else {
                System.out.println("a");
            }
        }
    }
}