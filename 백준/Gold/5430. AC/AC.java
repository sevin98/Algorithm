import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            LinkedList<Integer> dq = new LinkedList<>();
            if (n > 0) {
                String[] numbers = input.substring(1, input.length() - 1).split(",");
                for (String num : numbers) {
                    dq.add(Integer.parseInt(num));
                }
            }
            boolean reverse = false;
            boolean error = false;

            for (char command : p.toCharArray()) {
                if (command == 'R') {
                    reverse = !reverse;
                } else if (command == 'D') {
                    if (dq.isEmpty()) {
                        error = true;
                        break;
                    } else {
                        if (reverse) dq.pollLast();
                        else dq.pollFirst();
                    }
                }
            }// 명령어

            if (error) sb.append("error\n");
            else {

                sb.append("[");
                int size = dq.size();
                if (reverse) {
                    for (int i = 0; i < size; i++) {
                        sb.append(dq.pollLast());
                        if (dq.size() > 0) sb.append(",");
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        sb.append(dq.pollFirst());
                        if (dq.size() > 0) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }//tc
        System.out.println(sb);
    }//main
}