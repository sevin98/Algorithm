import java.util.Scanner;

public class Main {
    // 1초,
        static String accep = " is acceptable.";
        static String reject = " is not acceptable.";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        boolean flag;

        while(true){
        int cnt = 0;
        char p = '.';

            String password = sc.nextLine();
            if(password.equals("end")) break;

            char[] c = password.toCharArray();
            flag = false;
            for(int i = 0; i < c.length; i++){
                if(isChecked(c[i])) flag = true;

                if(isChecked(c[i]) != isChecked(p)) cnt =1;
                else cnt++;


                if(cnt  > 2 || (p == c[i] && c[i] != 'o' && c[i]!= 'e')){
                    flag = false;
                    break;
                }
                p = c[i];

            }
                if(flag) sb.append("<").append(password).append(">").append(accep).append("\n");
                else sb.append("<").append(password).append(">").append(reject).append("\n");
        }
        System.out.println(sb);
    }
    static boolean isChecked(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}