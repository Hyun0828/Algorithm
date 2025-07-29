import java.util.*;

class Solution {
    
    static boolean isOk = false;
    // static int[] visited;
    static boolean[] visited;
    static int answer = -1;
    
    public int solution(int x, int y, int n) {
        // visited = new int[1000001];
        visited = new boolean[1000001];
        // DFS(x, y, n, 0);
        // if(isOk)
            // return visited[y];
        // return -1;
        BFS(x,y,n);
        return answer;
    }
    
    public static void BFS(int x, int y, int n){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, 0));
                
        while(!queue.isEmpty()){
            Pair current = queue.poll();
            int currentValue = current.v;
            int currentHeight = current.h;
            
            if(currentValue == y){
                answer = currentHeight;
                return;
            }
            
            if(currentValue > y)
                continue;
            
            if(visited[currentValue])
                continue;
            
            visited[currentValue] = true;
            
            queue.add(new Pair(currentValue+n, currentHeight+1));
            queue.add(new Pair(currentValue*2, currentHeight+1));
            queue.add(new Pair(currentValue*3, currentHeight+1));
        }
    }
    
    static class Pair {
        int v;
        int h;
        
        public Pair(int v, int h){
            this.v=v;
            this.h=h;
        }
    }
    
//     public static void DFS(int x, int y, int n, int count){
        
//         if (x > y) {
//             return;
//         }
        
//         if (visited[x] > 0 && visited[x] <= count) {
//             return;
//         }
        
//         visited[x] = count;
        
//         if (x == y) {
//             isOk = true;
//             return;
//         }
        
//         DFS(x+n, y, n, count+1);
//         DFS(x*2, y, n, count+1);
//         DFS(x*3, y, n, count+1);
//     }
}