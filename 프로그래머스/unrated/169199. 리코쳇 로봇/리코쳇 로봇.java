import java.util.*;

class Solution {
    public int solution(String[] board) {
        int answer = -1;
     
        int y_size= board.length;
        int x_size= board[0].length();
        
        boolean[][] visited = new boolean[y_size][x_size];
        
        Queue<int[]> que = new LinkedList<>();
        
        for(int i=0;i<y_size;i++){
            for(int j=0;j<x_size;j++){
                if(board[i].charAt(j)=='R'){
                    // y ,x , level
                    que.add(new int[]{i,j,0});
                    visited[i][j]=true;
                }
            }
        }
        
        while(!que.isEmpty()){
            
            int[] q =que.poll();
            
            int y = q[0];
            int x = q[1];
            int level = q[2];
            
            if(board[y].charAt(x)=='G'){
                return level;
            }
            
            // x,y증분
            int dx=1;
            int dy=1;
            
            // Right
            while(x+dx!=x_size&&board[y].charAt(x+dx)!='D'){
                
                // if(x+dx==x_size||board[y].charAt(x+dx)=='D'){
                //     break;
                // }
                
                dx++;            
            }
            
            if(!visited[y][x+dx-1]){
                que.add(new int[]{y,x+dx-1,level+1});
                visited[y][x+dx-1]=true;
            }
            
            dx=1;
            
            //UP
            while(y-dy!=-1&&board[y-dy].charAt(x)!='D'){
                dy++;
            }
            
            if(!visited[y-dy+1][x]){
                que.add(new int[]{y-dy+1,x,level+1});
                visited[y-dy+1][x]=true;
            }
            dy=1;
            
            //Left
            while(x-dx!=-1&&board[y].charAt(x-dx)!='D'){
                dx++;
            }
            
            if(!visited[y][x-dx+1]){
                que.add(new int[]{y,x-dx+1,level+1});
                visited[y][x-dx+1]=true;
            }
            dx=1;
            
            //Down        
            while(y+dy!=y_size&&board[y+dy].charAt(x)!='D'){
                dy++;
            }                     
            if(!visited[y+dy-1][x]){
                que.add(new int[]{y+dy-1,x,level+1});
                visited[y+dy-1][x]=true;
            }
            dy=1;
            
            
        }
        
        return answer;
    }
}
