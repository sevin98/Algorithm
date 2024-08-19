import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int b = sc.nextInt();
            double p = sc.nextDouble();

            double BPM = b * 60 / p;
            double minABPM = (b - 1) * 60 / p;
            double maxABPM = (b + 1) * 60 / p;

            sb.append(String.format("%.4f %.4f %.4f", minABPM, BPM, maxABPM)).append("\n");
        }
        System.out.println(sb);
    }
}