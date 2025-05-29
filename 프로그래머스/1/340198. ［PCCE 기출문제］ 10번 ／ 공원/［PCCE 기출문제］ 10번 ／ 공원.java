import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        int n = park.length;
        int m = park[0].length;

        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            for (int r = 0; r <= n-size; r++) {
                for (int c = 0; c <= m-size; c++) {
                    if(possible(r, c, size, park)) return size;
                }
            }
        }
        return -1;
    }
    public boolean possible(int row, int col, int size, String[][] park){
        for(int r= row; r < row+size; r++){
            for(int c= col; c < col+size; c++){
                if(!park[r][c].equals("-1")) return false;
            }
        }
        return true;
    }
}