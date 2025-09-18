import java.util.*;

class Solution {
    
    int[] rank;
    int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = 100000000;
        
        for(int i=0; i<wires.length; i++){
            rank = new int[n+1];
            parent = new int[n+1];
            for(int j=1; j<=n; j++){
                rank[j] = 0;
                parent[j] = j;
            }
        
            for(int j=0; j<wires.length; j++){
                if(i==j)
                    continue;
                
                int x = wires[j][0];
                int y = wires[j][1];
                
                union(x, y);
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=1; j<=n; j++){
                int root = find(j);
                map.put(root, map.getOrDefault(root, 0) + 1);
            }
            
            if(map.size() != 2){
                continue;
            }
            
            List<Integer> keys = new ArrayList<>();
            for(Integer k : map.keySet()){
                keys.add(k);
            }
            
            int v1 = 0;
            int v2 = 0;
            for(int j=0; j<2; j++){
                if(j==0)
                    v1 = map.get(keys.get(j));
                else if(j==1)
                    v2 = map.get(keys.get(j));
            }
            
            answer = (int)Math.min(answer, Math.abs(v1-v2));
        }
        
        return answer;
    }
    
    public int find(int x){
        if(x==parent[x]){
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int A = find(a);
        int B = find(b);
        
        if(A == B){
            return;
        }
        
        if(rank[A] > rank[B]){
            parent[B] = A;
        } else {
            parent[A] = B;
            if(rank[A] == rank[B]){
                rank[B]++;
            }
        }
    }
}