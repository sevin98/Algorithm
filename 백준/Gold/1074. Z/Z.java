import java.awt.image.DataBufferDouble;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int cnt;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        // 배열 크기는 2^n X 2^N;
        int size = (int) Math.pow(2, N);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find(size, r, c);

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    static void find(int size, int r, int c) {
        if (size == 1) return;

        if (r < size / 2 && c < size / 2) {
            find(size / 2, r, c);
        } else if (r < size / 2 && c >= size / 2) {
            cnt += size * size / 4;
            find(size / 2, r, c - size / 2);
        } else if (r >= size /2 && c < size / 2) {
            cnt += (size * size / 4) * 2;
            find(size/ 2, r- size/2, c);
        } else{
            cnt += (size * size / 4) * 3;
            find(size / 2, r - size/2, c - size / 2);
        }
    }
}