import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // queue를 두개 생성한다.
        // 다리와, 대기중인 트럭
        
        //대기중인 트럭 초기화
        Queue<Integer> wait = new LinkedList<>();
        for(int w : truck_weights) wait.offer(w);
    
        // 다리는 전부 다 000000000000인 큐로 초기화
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0 ; i < bridge_length; i++) bridge.offer(0);
        
        int time = 0 ; // 매 초 올라갈 time
        int currWeight = 0 ; // 현재 다리에 올라가있는 무게
        
        // 대기중인 트럭이 끝나야하고, 현재 다리에 올라가있는 무게가 0일때까지 돌아야함
        while(!wait.isEmpty() || currWeight != 0){
            // 1초 지남
            time++; 
            
            // 맨 앞칸을 뺌
            currWeight -= bridge.poll();
            
            // 새로운 트럭 진입 여부
            if(!wait.isEmpty() && currWeight + wait.peek() <= weight){
                //올라갈 수 있을때
                int truck = wait.poll();
                bridge.offer(truck);
                currWeight+=truck;
            }//못올라가면 또 0으로 큐를 채워야함(그래야 다음 반복시 한 칸 전진 가능)
            else{
                bridge.offer(0);
            }
        }
        return time;
    }
}