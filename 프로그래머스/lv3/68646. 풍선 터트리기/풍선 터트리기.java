class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int l = a[0], r = a[a.length - 1];
        int answer = 2;
        
        for (int i = 1; i < a.length; i++) {
            if (a[i] < l) l = a[i];
            leftMin[i] = l;
        }
        
        for (int i = a.length - 2; i >= 0; i--) {
            if (a[i] < r) r = a[i];
            rightMin[i] = r;
        }
        
        if (a.length == 1) return 1;
        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            ++answer;
        }
        
        return answer;
    }
}