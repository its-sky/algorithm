import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int[] cards) {
        int answer = 0;
        parent = new int[cards.length + 1];
        
        for (int i = 1; i <= cards.length; i++) {
            parent[i] = i;
        }
        
        boolean[] checked = new boolean[cards.length + 1];
        
        for (int i = 1; i <= cards.length; i++) {
            int curr = i;
            while (true) {
                if (find(curr) != find(cards[curr - 1])) {
                    union(curr, cards[curr - 1]);
                    curr = cards[curr - 1];
                    System.out.println("curr:" + curr);
                } else {
                    break;
                }
            }
        }
        
        int[] count = new int[parent.length];
        
        for (int i = 1; i < parent.length; i++) {
            count[parent[i]] += 1;
        }
        
        Arrays.sort(count);
        
        if (count[count.length - 2] == 0) return 0;
        
        return count[count.length - 2] * count[count.length - 1];
    }
    
    private int find(int num) {
        if (num == parent[num]) return num;
        return parent[num] = find(parent[num]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        
        if (a == b) return;
        
        if (a <= b) parent[b] = a;
        else parent[a] = b;
    }
    
    // union-find 문제
    
    // 1 2 3 4 2 2 4 1
}