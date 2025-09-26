import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        
        Stack<Integer> s = new Stack<>();
        for(int i = 0;  i < n; i++){
            while(!s.isEmpty() && prices[i] < prices[s.peek()] ){
                res[s.peek()] = i - s.peek();
                s.pop();
            }
            s.push(i);
        }
        
        while(!s.isEmpty()){
            res[s.peek()] = n - s.peek() -1;
            s.pop();
        }
        return res;
    }
}