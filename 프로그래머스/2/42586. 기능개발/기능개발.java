import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        //progresses 배열은 해당 인덱스의 진도율
        
        //speeds 는 해당 인덱스의 스피드
        
        //배포는 해당인덱스의 진도율이 >= 100 되었을때
        
        //첫번째 인덱스의 기능이 완료되었을 때, 완료되어있는 모든 기능 returnㅊ
        //return 은 한번에 몇개의 기능이 배포되는지
        
        Queue<Integer> queue = new LinkedList<>();
        
        List<Integer> res = new ArrayList<>();
        
        for(int i = 0 ; i < progresses.length;i++){
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(days);
        }
        
        int currMax = queue.poll();
        int cnt = 1;
        
        while(!queue.isEmpty()){
            int day = queue.poll();
            
            if(day <= currMax){
                cnt++;
            }
            else{
                res.add(cnt);
                cnt = 1; 
                currMax = day;
            }
        }
        res.add(cnt);
      
        int[] result = new int[res.size()];
        
        for(int i = 0 ; i < res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
}