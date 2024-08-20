import java.util.Scanner;

public class Main {

    static boolean isFinished = false;
    static int[][] match;
    static int MAX_TEAM = 6;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = 4;
        StringBuilder sb = new StringBuilder();
        // 최대 경기 가능 횟수
        int size = 0;
        for (int i = 0; i < MAX_TEAM; i++) {
            size += i;
        }

        match = new int[size][2];
        int index = 0;
        for (int i = 0; i < MAX_TEAM - 1; i++) {
            for (int j = i + 1; j < MAX_TEAM; j++) {
                match[index][0] = i;
                match[index][1] = j;
                index++;
            }
        }

        while (T-- > 0) {
            int[][] worldCup = new int[MAX_TEAM][3]; // 행 팀 열 승무패
            boolean isPossible = true; // 정상적인 게임인지

            for (int i = 0; i < MAX_TEAM; i++) {
                int win = sc.nextInt();
                int draw = sc.nextInt();
                int lose = sc.nextInt();

                worldCup[i][0] = win;
                worldCup[i][1] = draw;
                worldCup[i][2] = lose;

                if (win + draw + lose != 5) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                backTracking(worldCup, 0, size);
                if (isFinished)
                    sb.append(1);
                else
                    sb.append(0);
            } else {
                sb.append(0);
            }

            sb.append(" ");
            isFinished = false;

            sc.nextLine();
        }
        System.out.print(sb);
    }

    static void backTracking(int[][] worldCup, int matchCount, int size) {
        if(isFinished) return;

        if (matchCount == size) {
            isFinished = true;
            return;
        }

        // 게임 로직
        // 첫판 검증하고
        // 첫 판 기준으로 돌리고
        // 안되면 다시 돌아와서 돌리고
        int teamA = match[matchCount][0];
        int teamB = match[matchCount][1];

        // teamA 와 teamB 의 전적 누적
        if (worldCup[teamA][0] > 0 && worldCup[teamB][2] > 0) {
            // 입력받았던 것에서 -- 해서 가능한지 체크
            worldCup[teamA][0]--;
            worldCup[teamB][2]--;
            // 한판 한거니까 matchCOunt 증가
            backTracking(worldCup, matchCount + 1, size);
            worldCup[teamA][0]++;
            worldCup[teamB][2]++;
            // 초기화 시켜놓기
        }

        // teamA 와 teamB 무승부
        if (worldCup[teamA][1] > 0 && worldCup[teamB][1] > 0) {
            worldCup[teamA][1]--;
            worldCup[teamB][1]--;
            // 한판 한거니까 matchCOunt 증가
            backTracking(worldCup, matchCount + 1, size);
            worldCup[teamA][1]++;
            worldCup[teamB][1]++;
            // 초기화 시켜놓기
        }

        // teamA 패 teamB 승
        if (worldCup[teamA][2] > 0 && worldCup[teamB][0] > 0) {
            worldCup[teamA][2]--;
            worldCup[teamB][0]--;
            // 한판 한거니까 matchCOunt 증가
            backTracking(worldCup, matchCount + 1, size);
            worldCup[teamA][2]++;
            worldCup[teamB][0]++;
            // 초기화 시켜놓기
        }
    }
}