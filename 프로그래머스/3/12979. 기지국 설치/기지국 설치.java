class Solution {
    public int solution(int n, int[] stations, int width) {
        int answer = 0;
        
        int currLocation = 1;
        int stationsLocation = 0 ;
        
        while(currLocation <= n){
            
            if(stationsLocation < stations.length && stations[stationsLocation] - width <= currLocation){
                
                currLocation = stations[stationsLocation] + width + 1;
                stationsLocation++;
            }
            else {
            answer++;
            currLocation += 2 * width + 1;
         }
        }
        return answer;
    }
}