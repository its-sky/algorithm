class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = numbers.clone();
        
        for (int i = 0; i < numbers.length; i++) {
            ++answer[i]; // x보다 큰수로 만든다.
            answer[i] += (answer[i] ^ numbers[i]) >> 2;
        }
        
        return answer;
    }
}// 11 -> 1011
// 111 -> 1110
// 110 -> 111

// 11111
// 111110
// 111111
// 101111