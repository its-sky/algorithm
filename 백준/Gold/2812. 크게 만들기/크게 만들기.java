import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Character> deq = new LinkedList<Character>();
		StringBuilder sb = new StringBuilder();
		int count = K;
		
		String S = br.readLine();
		//시작 값을 저장.
        deq.offer(S.charAt(0));
        //0인덱스 값은 이미 저장 했으니 1인덱스부터 반복
		for(int i = 1; i < N; i++) {
			char ichar = S.charAt(i);
			//덱의 마지막 값이 작으면 조건들이 충족되는 한 계속 제거.
			while(deq.getLast() < ichar && count != 0) {
				deq.pollLast();
				count--;
				//덱이 비게되면 반복 종료
                if(deq.isEmpty()) break;
			}
			deq.offer(S.charAt(i));
		}
		int size = deq.size();
        //count에 값이 남아있을 수도 있기에 count값을 제외한 개수만큼만 출력
		for(int i = 0; i < size - count; i++) {
			sb.append(deq.pollFirst());
		}
		
		System.out.println(sb);
    }
}