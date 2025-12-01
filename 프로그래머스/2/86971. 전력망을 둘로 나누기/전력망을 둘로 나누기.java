import java.util.*;

class Solution {
    
    int[] rank;
    int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = 100000000;
        
        for(int i=0; i<wires.length; i++){
            init(n);
            
            for(int j=0; j<wires.length; j++){
                if(i==j)
                    continue;
                union(wires[j][0], wires[j][1]);
            }
            
            for(int j=1; j<=n; j++)
                find(j);
            
            Map<Integer, Integer> map = new HashMap<>();
            for(int j=1; j<=n; j++){
                map.put(parent[j], map.getOrDefault(parent[j], 0) + 1);
            }
            int[] tmp = new int[2];
            int idx = 0;
            for(Integer k : map.keySet()){
                tmp[idx++] = map.get(k);
            }
            answer = Math.min(answer, Math.abs(tmp[0] - tmp[1]));
        }
        
        return answer;
    }
    
    public void init(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            rank[i] = 1;
            parent[i] = i;
        }
    }
    
    public int find(int x){
        if(x == parent[x])
            return parent[x];
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        
        if(pa == pb)
            return;
        
        if(rank[pa] > rank[pb]){
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
            if(rank[pa] == rank[pb]){
                rank[pb]++;
            }
        }
    }
}