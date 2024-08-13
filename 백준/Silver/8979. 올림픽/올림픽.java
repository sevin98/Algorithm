import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Nation implements Comparable<Nation> {
        int num, gold, silver, bronze;

        public Nation(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                } else return o.silver - this.silver;
            } else return o.gold - this.gold;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 국가의 수 N
        int K = sc.nextInt(); // 등수를 할고싶은국가 M
        sc.nextLine();
        List<Nation> list = new ArrayList<>();
        int number = N;
        while (N-- > 0) {
            int num = sc.nextInt();
            int gold = sc.nextInt();
            int silver = sc.nextInt();
            int bronze = sc.nextInt();
            Nation nation = new Nation(num, gold, silver, bronze);
            list.add(nation);
        }
        Collections.sort(list);

        int rate = 1;
        int cnt = 1;

        if (list.get(0).num == K) {
            System.out.println(1);
            return;
        }

        for (int i = 1; i < number; i++) {
            Nation prev = list.get(i - 1);
            Nation curr = list.get(i);

            if ((prev.gold != curr.gold) || (prev.silver != curr.silver) || (prev.bronze != curr.bronze)) {
                rate += cnt;
                cnt = 1;
            } else cnt++;

            if (curr.num == K) {
                System.out.println(rate);
                break;
            }
        }
    }
}