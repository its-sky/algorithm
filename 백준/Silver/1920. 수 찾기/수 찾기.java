import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, Integer> map = new HashMap<>();

		int N = Integer.parseInt(br.readLine());

		String[] tmp = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int target = Integer.parseInt(tmp[i]);
			map.put(target, map.getOrDefault(target, 0) + 1);
		}

		int M = Integer.parseInt(br.readLine());

		tmp = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(tmp[i]);
			if (map.containsKey(target))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}
}
