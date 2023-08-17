import java.util.*;

class Solution {
    static List<Node> list;
    static int[][] answer;
    static int idx;
    
    public int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        list = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            Node tmp = new Node(i + 1, nodeinfo[i]);
            list.add(tmp);
        }
        
        Collections.sort(list);
        
        Node head = list.get(0);
        
        for (int i = 1; i < list.size(); i++) {
            insertNode(head, list.get(i));
        }
        
        idx = 0;
        preOrder(head);
        idx = 0;
        postOrder(head);
        
        return answer;
    }
    
    private void preOrder(Node curr) {
        if (curr != null) {
            answer[0][idx++] = curr.num;
            if (curr.left != null) preOrder(curr.left);
            if (curr.right != null) preOrder(curr.right);
        }
    }
    
    private void postOrder(Node curr) {
        if (curr != null) {
            if (curr.left != null) postOrder(curr.left);
            if (curr.right != null) postOrder(curr.right);
            answer[1][idx++] = curr.num;
        }
    }
    
    private void insertNode(Node parent, Node child) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    static class Node implements Comparable<Node> {
        public int num;
        public int x, y;
        public int[] info;
        public Node left;
        public Node right;
        
        public Node(int num, int[] info) {
            this.num = num;
            this.x = info[0];
            this.y = info[1];
            this.left = null;
            this.right = null;
        }
        
        @Override
        public int compareTo(Node t) {
            if (this.y > t.y) return -1;
            else if (this.y == t.y) {
                if (this.x < t.x) return -1;
                else return 1;
            } else return 1;
        }
    }
}