import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
            // 하드디스크는 그냥 큐
            // 대기큐에서 모든걸 정렬해줘야함
            //1. 작업의 소요시간이 짧은것
            //2. 작업의 요청시간이 빠른것
            //3. 작업의 번호가 작은것
            
            //jobs[i] 는 [0,3]
            //jobs[i] 의 [0]은 요청시간
            //jobs[i] 의 [1]은 소요시간
            //job들 중에 요청시각기준 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }
        });
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            }
        });
        
        int n = jobs.length;
        int idx = 0;
        int done = 0;
        int time = 0;
        long sum = 0;
        while(done < n){
             // 현재 시간까지 도착한 작업을 PQ에 투입
            while(idx < n && jobs[idx][0] <= time){
                pq.offer(jobs[idx]);
                idx++;
            }
            
            if(pq.isEmpty()){
                time = Math.max(time, jobs[idx][0]);
                continue;
            }
            int[] job = pq.poll();
            time += job[1];
            sum += (time - job[0]);
            done++;
        }
        return (int)(sum / n);
    }
}