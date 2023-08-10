import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String table : timetable) {
            int time = Integer.parseInt(table.substring(0,2)) * 60 + Integer.parseInt(table.substring(3));
            pq.add(time);
        }
        
        int start_time = 9 * 60;
        int last_time = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = 0;
            while (!pq.isEmpty()) {
                int curr_time = pq.peek();
                if (curr_time <= start_time && total < m) {
                    ++total;
                    pq.poll();
                } else break;
                last_time = curr_time - 1;
            }
            start_time += t;
        }
        if (total < m) last_time = start_time - t;
        
        String hour = String.format("%02d", last_time / 60);
        String minute = String.format("%02d", last_time % 60);
        return hour + ":" + minute;
    }
}

// 먼저 시각을 버스가 도착하는 가장 늦은 시각으로 설정
// 맨 뒤부터 비교하면서 내가 버스에 탈 수 있는지를 점검하면서
// 만약 도착했을때 못타면 해당 사람을 제끼는 시간으로 변경
// 이것을 탈 수 있을 때까지 변경하면 됨

// 버스 1대에 대한 예외처리를 해야할듯?
// 버스가 2대 이상이면 마지막 1대를 제외한 나머지 버스에서 처리할 수 있는 timetable 먼저 처리

//35781016172024