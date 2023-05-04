class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int cal = s / n;
        int other = s % n;
        if (cal == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        for (int i=0; i<n; i++) {
            answer[i] = cal;
        }
        for (int i=n-1; i>n-1-other; i--) {
            answer[i] += 1;
        }
        
        return answer;
    }
}