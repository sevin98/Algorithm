import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = getLIS(arr);
        bw.write(lis.size() + "\n");
        for (Integer li : lis) {
            bw.write(li + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static List<Integer> getLIS(int[] arr) {
        int[] res = new int[arr.length];
        int[] indices = new int[arr.length];
        int[] predecessors = new int[arr.length];
        Arrays.fill(predecessors, -1);

        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int idx = binarySearch(res, 0, length, arr[i]);

            res[idx] = arr[i];
            indices[idx] = i;

            if (idx > 0) {
                predecessors[i] = indices[idx - 1];
            }

            if (idx == length) {
                length++;
            }
        }

        List<Integer> lis = new ArrayList<>();
        for (int i = indices[length - 1]; i >= 0; i = predecessors[i]) {
            lis.add(arr[i]);
        }

        Collections.reverse(lis);
        return lis;
    }

    static int binarySearch(int[] lis, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (lis[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}