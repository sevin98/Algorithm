class Solution {
    public int solution(int sticker[]) {
        //dp문제
        int N = sticker.length;
        
        if(N == 1) return sticker[0];
        
        int[] dp1 = new int[N];
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
       
        for(int i = 2; i < N; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }
        
        int[] dp2 = new int[N];
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i = 2; i < N; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
       
         //첫 번째 스티커를 포함하면 마지막 스티커는 선택할 수 없음
        return Math.max(dp1[N-2], dp2[N-1]);
    
    }
}