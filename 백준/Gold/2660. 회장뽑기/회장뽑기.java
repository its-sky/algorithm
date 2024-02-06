// 해당 사람과 연결된 리스트를 한 반복문에서 돌고 다 돌았는데 회원수보다 작으면
// 점수를 카운트하고 큐에 들어간 다음 사람을 꺼내서 해당 큐 사람의 지인을 모두 돌고
// 다시 체크 이런 식으로 사람 점수 체크는 static class 만들어서 관리하자

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<List<Integer>> rel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        rel = new ArrayList<List<Integer>>();
        for (int i = 0; i <= N; i++) {
            rel.add(new ArrayList<>());
        }
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            rel.get(a).add(b);
            rel.get(b).add(a);
        }
        if (rel.size() == 0) return;
        
        List<Person> resList = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            resList.add(new Person(i, bfs(i)));
        }
        Collections.sort(resList, (o1, o2) -> {
            if (o1.score == o2.score) {
                return o1.n - o2.n;
            }
            return o1.score - o2.score;
        });
        
        int firstScore = resList.get(0).score;
        int count = 1;
        List<Integer> cand = new ArrayList<>();
        cand.add(resList.get(0).n);
        if (resList.size() > 1) {
            for (int i = 1; i < resList.size(); i++) {
                if (firstScore == resList.get(i).score) {
                    ++count;
                    cand.add(resList.get(i).n);
                } else {
                    break;
                }
            }
        }
        Collections.sort(cand, (o1, o2) -> {
           return o1 - o2; 
        });
        System.out.println(firstScore + " " + count);
        System.out.print(cand.get(0));
        if (cand.size() > 1) {
            for (int i = 1; i < cand.size(); i++) {
                System.out.print(" " + cand.get(i));
            }
        }
        br.close();
    }
    
    private static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Friend> q = new LinkedList<>();
        q.offer(new Friend(start, 1));
        visited[start] = true;
        int countedFriend = 0;
        int step = 0;
        
        while (!q.isEmpty()) {
            Friend curr = q.poll();
            List<Integer> friends = rel.get(curr.n);
            if (friends.size() > 0) {
                for (Integer fr : friends) {
                    if (!visited[fr]) {
                        step = curr.dist;
                        q.offer(new Friend(fr, curr.dist + 1));
                        visited[fr] = true;
                        ++countedFriend;
                    }
                }
            }
            if (countedFriend == N) {
                break;
            }
        }
        return step;
    }
    
    static class Friend {
        public int n, dist;
        
        public Friend(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }
    
    static class Person {
        public int n, score;
        
        public Person(int n, int score) {
            this.n = n;
            this.score = score;
        }
    }
}