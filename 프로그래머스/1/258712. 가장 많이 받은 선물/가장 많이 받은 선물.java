import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        Map<String, Integer> giveCount = new HashMap<>();
        Map<String, Integer> receiveCount = new HashMap<>();
        Map<String, Map<String, Integer>> giftRecord = new HashMap<>();
        Map<String, Integer> nextMonthReceive = new HashMap<>();
        
        for(String f : friends){
            giveCount.put(f, 0);
            receiveCount.put(f, 0);
            giftRecord.put(f, new HashMap<>());
            nextMonthReceive.put(f, 0);
        }
        
        for(String g : gifts){
            String[] gift = g.split(" ");
            String from = gift[0];
            String to = gift[1];
            
            giveCount.put(from, giveCount.get(from) + 1);
            receiveCount.put(to, receiveCount.get(to) + 1);
            
            giftRecord.get(from).put(to, giftRecord.get(from).getOrDefault(to, 0) + 1);
        }
        
        Map<String, Integer> score = new HashMap<>();
        for(String f : friends){
            int give = giveCount.get(f);
            int receive = receiveCount.get(f);
            score.put(f, give - receive);
        }
        
        for(int i = 0 ; i < friends.length; i++){
            String a = friends[i];
            for(int j = i +1 ; j < friends.length; j++){
                String b = friends[j];
                
                int AtoB = giftRecord.get(a).getOrDefault(b, 0);
                int BtoA = giftRecord.get(b).getOrDefault(a, 0);
                
                if(AtoB > BtoA){
                    nextMonthReceive.put(a, nextMonthReceive.get(a) +1);
                }else if(AtoB < BtoA){
                    nextMonthReceive.put(b, nextMonthReceive.get(b) +1);
                }else{
                    int aScore = score.get(a);
                    int bScore = score.get(b);
                    
                    if(aScore > bScore){
                        nextMonthReceive.put(a, nextMonthReceive.get(a) +1);
                    }else if(bScore > aScore){
                        nextMonthReceive.put(b, nextMonthReceive.get(b) +1);
                    }
                }
            }
        }
        
        int max = 0;
        for(int num : nextMonthReceive.values()){
            max = Math.max(num, max);
        }
        return max;
    }
}