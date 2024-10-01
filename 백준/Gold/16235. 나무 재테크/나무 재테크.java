import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1}, dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[][] map, addition;
    static List<Tree> trees = new ArrayList<>();
    static Queue<Integer> removeTrees = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        addition = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], 5);
        }
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                addition[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x-1, y-1, age));
        }
        br.close();
        Collections.sort(trees);
        
        for (int i = 0; i < K; i++) {
            spendYear();
        }
        
        System.out.println(trees.size());
    }
    
    private static void spendYear() {
        spring();
        
        summer();
        
        fall();
        
        winter();
    }
    
    private static void spring() {
        for (int i = 0; i < trees.size(); i++) {
            Tree tree = trees.get(i);
            if (tree.isDead) continue;
            if (tree.age > map[tree.x][tree.y]) {
                removeTrees.offer(i);
                continue;
            }
            map[tree.x][tree.y] -= tree.age;
            tree.age += 1;
        }
    }
    
    private static void summer() {
        while (!removeTrees.isEmpty()) {
            Integer deadTreeIdx = removeTrees.poll();
            Tree deadTree = trees.get(deadTreeIdx);
            map[deadTree.x][deadTree.y] += deadTree.age / 2;
            deadTree.isDead = true;
        }
    }
    
    private static void fall() {
        List<Tree> newTrees = new ArrayList<>();
        
        for (Tree tree : trees) {
            if (tree.isDead) continue;
            
            if (tree.age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = tree.x + dx[i];
                    int ny = tree.y + dy[i];
                    
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    
                    newTrees.add(new Tree(nx, ny, 1));
                }
            }
        }
        for (Tree tree : trees) {
            if (!tree.isDead) {
                newTrees.add(tree);
            }
        }
        trees = newTrees;
    }
    
    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += addition[i][j];
            }
        }
    }
}

class Tree implements Comparable<Tree> {
    int x, y, age;
    boolean isDead;
    
    public Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }
    
    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}