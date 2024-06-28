import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        
//         Arrays.sort(arr, new Comparator<String>() {
            
//             public int compare(String o1, String o2) {
//                 return Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
//             }
//         });
        
        Arrays.sort(arr, (o1, o2) -> Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2)));
        
        answer = arr[0] + " " + arr[arr.length - 1];
        
        return answer;
    }
}