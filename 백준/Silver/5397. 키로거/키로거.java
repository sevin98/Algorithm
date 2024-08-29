import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static char[] data;
    static int[] prev, next;
    static int cursor, currIdx;
    static final int MAX_LENGTH = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String line = br.readLine();

            data = new char[MAX_LENGTH];
            prev = new int[MAX_LENGTH];
            next = new int[MAX_LENGTH];

            cursor = 0;
            currIdx = 1;

            prev[0] = -1;
            next[0] = -1;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                switch (c) {
                    case '<':
                        if (prev[cursor] != -1)
                            cursor = prev[cursor];
                        break;
                    case '>':
                        if (next[cursor] != -1)
                            cursor = next[cursor];
                        break;
                    case '-':
                        if (prev[cursor] != -1)
                            delete();
                        break;
                    default:
                        insert(c);
                        break;
                }
            }
            int index = next[0];
            while (index != -1) {
                sb.append(data[index]);
                index = next[index];
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void insert(char ch) {
        if (currIdx >= MAX_LENGTH)
            return;


        data[currIdx] = ch;
        prev[currIdx] = cursor;
        next[currIdx] = next[cursor];

        if (next[cursor] != -1)
            prev[next[cursor]] = currIdx;

        next[cursor] = currIdx;
        cursor = currIdx;
        currIdx++;
    }

    static void delete() {
        if (cursor == 0 || cursor >= currIdx)
            return;


        if (next[cursor] != -1)
            prev[next[cursor]] = prev[cursor];

        if (prev[cursor] != -1)
            next[prev[cursor]] = next[cursor];

        cursor = prev[cursor];
    }
}