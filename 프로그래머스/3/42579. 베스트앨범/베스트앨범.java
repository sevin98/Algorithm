import java.util.*;

class Solution {
    static class Song implements Comparable<Song>{
        int id;
        int plays;
        Song(int id, int plays){
            this.id = id;
            this.plays = plays;
        }
        
        // 재생수로 내림차순
        // 같을 땐 id 오름차순 고유번호가 낮은 노래 먼저 수록
        @Override
        public int compareTo(Song s){
            if(this.plays != s.plays)return s.plays - this.plays;
            return this.id - s.id;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        // 장르별 총 재생수, 여기서 상위 2개만 꺼내가야함
        Map<String, Integer> totalByGenre = new HashMap<>();
        
        // 클래스별 노래 리스트(고유번호, 재생목록)가 들어가는 맵
        Map<String, List<Song>> songsByGenre = new HashMap<>();
        
        for(int i =0 ; i < genres.length; i++){
            String g = genres[i];
            int p = plays[i];
            
            // 장르 키값에 해당하는 값이 있으면 그 값 + p
            totalByGenre.put(g, totalByGenre.getOrDefault(g, 0) + p); 
            
            // 처음 들어오는 노래면, 장르랑 노래를 리스트로변환해서 넣기
            if(!songsByGenre.containsKey(g)) {
                songsByGenre.put(g, new ArrayList<Song>());
            }
            // 이미 있는 노래면
            // 장르의 값을 찾아서, 리스트에 또다른 Song을 넣어준다. 
            songsByGenre.get(g).add(new Song(i, p));
    }
        // totalByGenre 를 가지고 장르별 리스트로 정의
        List<String> orderByGenre = new ArrayList<>(totalByGenre.keySet());
        Collections.sort(orderByGenre, new Comparator<String>(){
           @Override
            public int compare(String a, String b){
                return totalByGenre.get(b) - totalByGenre.get(a);
            }
        });
        
        // 리스트에서 상위 2곡 선택
        List<Integer> picked = new ArrayList<>();
        for(String g: orderByGenre){
            // 한 장르에 여러 노래가 있을 수도 있으니깐
            List<Song> songList = songsByGenre.get(g);
            Collections.sort(songList); // Song 객체에 정의한 compareTo 사용
            // 1곡만 들어있을 수도 있으니
            int take = Math.min(2, songList.size());
            for(int i = 0 ; i <take; i++){
                picked.add(songList.get(i).id);
            }
        }
        return picked;
    }
}