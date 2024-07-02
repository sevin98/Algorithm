import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0 ; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        int cnt = 0;
        
            while(pq.peek() < K){
                
                if(pq.size() == 1){
                    return -1;
                }
                
                int A = pq.poll();
                int B = pq.poll();
                
                int C = A + (B * 2);
                cnt++;
                pq.offer(C);
            }
        return cnt;
    }
}