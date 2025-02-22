import java.io.*;
import java.util.*;

public class Main {
    static int[] move = new int[101];
    public static void main(String[] args) throws IOException {
        // 코드를 작성해주세요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        for (int i = 1; i < 101; i++) {
            move[i] = i; 
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            move[a] = b;
        }
        
        br.close();
        
        System.out.println(bfs(1));
    }
    
    private static int bfs(int startNode) {
		int[] check = new int[101];
		Queue<Integer> q = new LinkedList<>();
		q.offer(startNode); //처음에 인덱스 1이 들어간다.
		check[startNode] = 0; 

		while (true) {
			int visitedNum = q.poll();
			//주사위 1~6이 나오는 경우를 살피기.
			for (int i = 1; i < 7; i++) {            	
				int newNode = visitedNum + i;
                
                // board의 범위를 넘기면 무시하기
                // - check 배열에 IndexOutOfBoundsException을 발생시킬 수 있기 때문
				if (newNode > 100) { 
					continue;
				}
                
                // check되어있는 경우(방문을 한적이 있는 경우)는 무시한다는 것을 전제로 함.
				if (check[move[newNode]] == 0) { 
					q.offer(move[newNode]);
					check[move[newNode]] = check[visitedNum] + 1;
				}
				if (move[newNode] == 100) {
					return check[100];
				}
			}

		}

	}
}

// 최소한으로 움직이는 것은 가장 낮은 숫자에서 가장 높은 숫자로 이동하는 사다리를 이용하는 것이 최선.
// 