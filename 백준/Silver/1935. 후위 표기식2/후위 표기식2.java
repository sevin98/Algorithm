import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        Stack<Double> stack = new Stack<>();
        Map<Character, Double> map = new HashMap<>();

        char key = 'A';
        for(int i = 0 ; i < t; i++){
            map.put(key, Double.parseDouble(br.readLine()));
            key++;
        }

        for(int i = 0 ; i < arr.length; i++){
            if ('A' <= arr[i] && arr[i] <= 'Z') stack.push(map.get(arr[i]));
            else{
                double res1 = stack.pop();
                double res2 = stack.pop();

                switch(arr[i]){
                    case '+' :
                        stack.push(res2 + res1);
                        break;
                    case '-' :
                        stack.push(res2 - res1);
                        break;
                    case '*' :
                        stack.push(res2 * res1);
                        break;
                    case '/' :
                        stack.push(res2 / res1);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}