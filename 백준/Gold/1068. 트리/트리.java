import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int root = -1;
		for(int i=0; i<n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num == -1) {
				root = i;
				continue;
			}
			list[num].add(i); 
		}
		
		int remove = Integer.parseInt(br.readLine());
		
		removeNode(remove);
		if(remove == root) {
			System.out.println(0);
		}else {
			System.out.println(findLeaf(root));
		}
	}
	static void removeNode(int node) {
		
		// 해당 노드 자식노드 모두 조회 
		if(list[node].size()>0) {
			int size = list[node].size();
			while(size>0) {
				int child = list[node].get(--size);
				removeNode(child);
			}
		}
		
		// 해당 노드 자식 노드 모두 삭제 
		for(int i=0; i<n; i++) {
			if(list[i].contains(node)) {
				for(int j=0; j<list[i].size(); j++) {
					if(list[i].get(j) == node) {
						list[i].remove(j);
					}
				}
			}
		}
	}
	
	static int findLeaf(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		int cnt=0;
		
		while(!q.isEmpty()) {
			int pos = q.poll();
			if(list[pos].size()==0) { 
				cnt++; // 리프노드 count
				continue;
			}
			
			for(int next : list[pos]) {
				q.add(next);
			}
		}
		return cnt;
	}
	
}