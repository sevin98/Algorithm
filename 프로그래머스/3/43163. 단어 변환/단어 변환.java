import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        
        boolean exists = false;
        for (String w : words){
            if(w.equals(target)){
                exists = true;
                break;
            }
        }
        if(!exists) return 0;
        
        boolean[] visited = new boolean[length];
        Queue<int[]> q = new LinkedList<>();
        
        //begin 과 1글자 차이나는 단어들부터 queue에 넣기
        for(int i = 0 ; i < length; i++){
            if(isOneDiff(begin, words[i])){
                visited[i] = true;
                q.offer(new int[]{i, 1});
            }
        }
        // bfs 돌리기
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int idx = cur[0];
            int dist = cur[1];
            
            if(words[idx].equals(target)) return dist;
            for(int i = 0 ; i < length; i++){
                if(!visited[i] && isOneDiff(words[idx], words[i])){
                    visited[i] = true;
                    q.offer(new int[]{i, dist+1});
                }
            }
        }
        return 0;
    }
    public boolean isOneDiff(String a, String b){
        int diff = 0;
        for ( int i = 0 ; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff>1) return false;
            } 
        }
        return diff == 1;
    }
}