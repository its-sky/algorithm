import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, ArrayList<Music>> map = new HashMap<>();
        ArrayList<Gen> list = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i]))
                map.put(genres[i], new ArrayList<>());
            Music music = new Music(i, plays[i]);
            map.get(genres[i]).add(music);
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        for (String key : count.keySet()) {
            list.add(new Gen(key, count.get(key)));
        }
        Collections.sort(list);
        while (true) {
            Gen curr = list.get(0);
            ArrayList<Music> music_list = map.get(curr.genre);
            Collections.sort(music_list);
            for (int i = 0; i < music_list.size(); i++) {
                if (i == 2)
                    break;
                answer.add(music_list.get(i).id);
            }
            list.remove(0);
            if (list.size() == 0)
                break;
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    static class Gen implements Comparable<Gen> {
        public String genre;
        public int play;
        
        public Gen(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }
        
        @Override
        public int compareTo(Gen gen) {
            if (this.play >= gen.play)
                return -1;
            else 
                return 1;
        }
    }
    
    static class Music implements Comparable<Music> {
        public int id;
        public int play;
        
        public Music(int id, int play) {
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Music m) {
            if (this.play > m.play)
                return -1;
            else if (this.play == m.play) {
                if (this.id < m.id)
                    return -1;
                else
                    return 1;
            } else return 1;
        }
    }
}