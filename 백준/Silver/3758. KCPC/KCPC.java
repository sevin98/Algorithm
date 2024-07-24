import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static class Team {
        int id;
        int[] score;
        int submitNum, lastSubmit, totalScore;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //테스트케이스 입력
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int T = sc.nextInt();
            int M = sc.nextInt();

            Team[] list = new Team[N];

            for (int i = 0; i < M; i++) {
                //id ,문제번호, 점수
                int I = sc.nextInt();
                int J = sc.nextInt();
                int S = sc.nextInt();

                if (list[I - 1] == null) {
                    list[I - 1] = new Team();
                    list[I - 1].id = I;
                    list[I - 1].score = new int[K + 1];
                }
                list[I - 1].score[J] = Math.max(S, list[I - 1].score[J]);
                list[I - 1].submitNum++;
                list[I - 1].lastSubmit = i;
            }

            for (int i = 0; i < N; i++) {
                int sum = 0;
                for (int j = 1; j <= K; j++) {
                    sum += list[i].score[j];
                }
                list[i].totalScore = sum;
            }

            Arrays.sort(list, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitNum == o2.submitNum) {
                            return o1.lastSubmit - o2.lastSubmit;
                        }
                        return o1.submitNum - o2.submitNum;
                    }
                    return o2.totalScore - o1.totalScore;
                }
            });

            for (int i = 0; i < N; i++) {
                if (list[i].id == T) {
                    System.out.println(i+1);
                }
            }
        }
    }
}