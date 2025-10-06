import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Student{
        String name;
        int korean;
        int english;
        int math;
        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());

            list.add(new Student(name, korean, english, math));
        }
        Collections.sort(list, new Comparator<Student>(){
            @Override
            public int compare(Student o1, Student o2){
                if(o1.korean == o2.korean){
                    if(o1.english == o2.english){
                        if(o1.math == o2.math){
                            return o1.name.compareTo(o2.name);
                        }
                        return o2.math - o1.math;
                    }
                    return o1.english - o2.english;
                }
                return o2.korean - o1.korean;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Student s : list){
            sb.append(s.name).append("\n");
        }
        System.out.println(sb);
    }
}
