import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int white, blue;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        StringTokenizer st;
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        recur(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    static void recur(int row, int col, int size) {
        // checkColor 가 true 반환할때 == 모든 값이 일치할때
        if (checkColor(row, col, size)) {
            if (arr[row][col] == 1) blue++;
            else white++;

            return;
        }

        int newSize = size / 2;

        recur(row, col, newSize);
        recur(row + newSize, col, newSize);
        recur(row, col + newSize, newSize);
        recur(row + newSize, col + newSize, newSize);
    }


    // 재귀적으로 작아진 사이즈마다 checkColor 를 해줘서 더 안줄여도 되는지 확인한다
    static boolean checkColor(int row, int col, int size) {
        int color = arr[row][col];

        for (int r = row; r < size + row; r++) {
            for (int c = col; c < size + col; c++) {
                if (arr[r][c] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}