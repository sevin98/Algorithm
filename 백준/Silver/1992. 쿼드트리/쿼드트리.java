import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static int white, blue;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int r = 0; r < N; r++) {
            String line = br.readLine();
            for (int c = 0; c < N; c++) {
                arr[r][c] = line.charAt(c) -'0';
            }
        }

        recur(0, 0, N);
        System.out.println(sb);

    }
    static void recur(int row, int col, int size){
        if(check(row, col, size)){
            if(arr[row][col] == 1)
                sb.append(1);
            else sb.append(0);

            return;
        }

        int newSize= size /2;

        sb.append("(");
        recur(row, col, newSize);
        recur(row, col + newSize, newSize);
        recur(row + newSize, col, newSize);
        recur(row + newSize, col + newSize, newSize);
        sb.append(")");
    }


    static boolean check(int row, int col, int size) {
        int color = arr[row][col];

        for (int r = row; r < size + row; r++) {
            for (int c = col; c < size + col; c++) {
                if (arr[r][c] != color)
                    return false;
            }
        }
        return true;
    }
}