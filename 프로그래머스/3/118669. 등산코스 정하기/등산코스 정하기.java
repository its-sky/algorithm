import java.util.*;

class Solution {
    static List<List<Node>> graph;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : paths) {
            int s = path[0];
            int e = path[1];
            int w = path[2];
            
            if (isGate(s, gates) || isSummit(e, summits)) {
                graph.get(s).add(new Node(e, w));
            } else if (isGate(e, gates) || isSummit(s, summits)) {
                graph.get(e).add(new Node(s, w));
            } else {
                graph.get(s).add(new Node(e, w));
                graph.get(e).add(new Node(s, w));
            }
        }
        
        return dijkstra(n, gates, summits);
    }
    
    private static int[] dijkstra(int n, int[] gates, int[] summits) {
        Queue<Node> q = new LinkedList<>();
        int[] intensity = new int[n + 1];
        
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        for (int gate : gates) {
            q.add(new Node(gate, 0));
            intensity[gate] = 0;
        }
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            if (curr.w > intensity[curr.e]) continue;
            
            for (int i = 0; i < graph.get(curr.e).size(); i++) {
                Node nn = graph.get(curr.e).get(i);
                
                int dis = Math.max(intensity[curr.e], nn.w);
                if (intensity[nn.e] > dis) {
                    intensity[nn.e] = dis;
                    q.add(new Node(nn.e, dis));
                }
            }
        }
        
        int mn = Integer.MAX_VALUE;
        int mw = Integer.MAX_VALUE;
        
        Arrays.sort(summits);
        
        for (int summit : summits) {
            if (intensity[summit] < mw) {
                mn = summit;
                mw = intensity[summit];
            }
        }
        
        return new int[]{mn, mw};
    }
    
    private static boolean isGate(int num, int[] gates) {
        for (int gate : gates) {
            if (num == gate) return true;
        }
        return false;
    }
    
    private static boolean isSummit(int num, int[] summits) {
        for (int summit : summits) {
            if (summit == num) return true;
        }
        return false;
    }
    
    static class Node {
        int e, w;
        
        public Node(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}

// 다익스트라인데 총 경로의 가중치의 합이 최소가 아니라 각 경로에 방문했을 때 최소를 선택해야함.
// 근데 최소를 선택했는데 최대가 나올 경우도 있음. 이거는 어떻게?

// 입구와 정상은 단방향 그래프로 만들면 됨