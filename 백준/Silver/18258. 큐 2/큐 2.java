import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력저장

        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            String temp = st.nextToken();
            switch (temp) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(queue.peek()).append('\n');
                        queue.poll();
                    }
                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(queue.peek()).append('\n');
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append('\n');
                    } else {
                        sb.append(((LinkedList<Integer>) queue).peekLast()).append('\n');
                    }
                    break;
            }
        }
        System.out.print(sb); // 한 번에 출력
    }
}
