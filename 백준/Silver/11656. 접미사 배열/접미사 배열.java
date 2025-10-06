import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String line = br.readLine();

        for(int i = 0; i < line.length(); i++){
            list.add(line.substring(i));
        }
        Collections.sort(list);
        for(String s : list){
            System.out.println(s);
        }
    }
}
