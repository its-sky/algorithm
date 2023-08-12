import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int item : B){
            arr.add(item);
        }
        
        Arrays.sort(A);
        Collections.sort(arr, Collections.reverseOrder());
        
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * arr.get(i);
        }
        
        return answer;
    }
}