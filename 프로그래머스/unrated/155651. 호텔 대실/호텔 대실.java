import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<String> pq = new PriorityQueue<>();
        Arrays.sort(book_time, (b1, b2) -> {
            if (b1[0].compareTo(b2[0]) == 0) {
                return b1[1].compareTo(b2[1]);
            }
            return b1[0].compareTo(b2[0]);
        });
        
        for (String[] book : book_time) {
            if (pq.size() > 0) {
                String end = clean(pq.peek());
                if (book[0].compareTo(end) >= 0) {
                    pq.poll();
                    pq.offer(book[1]);
                } else {
                    ++answer;
                    pq.offer(book[1]);
                }
            } else {
                ++answer;
                pq.offer(book[1]);
            }
        }
        
        return answer;
    }
    
    private String clean(String time) {
        String[] target = time.split(":");
        int hour = Integer.parseInt(target[0]);
        int min = Integer.parseInt(target[1]);
        min += 10;
        if (min >= 60) {
            hour += 1;
            min -= 60;
        }
        return String.format("%02d:%02d", hour, min);
    }
}

// 끝날때마다 최소 종료 시각으로 바꿔줘야함?