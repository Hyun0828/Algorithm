import java.util.*;

class Solution {
    
    int[] parent;
    int[] rank;
    
    public int solution(int n, int[][] wires) {
        int answer = 1000000000;
        
        for(int i=0; i<wires.length; i++){
            init(n);
            for(int j=0; j<wires.length; j++){
                if(i == j)
                    continue;
                int a = wires[j][0];
                int b = wires[j][1];
                union(a, b);
            }
            
            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for(int z=1; z<=n; z++){
                int root = find(z);
                set.add(root);
                map.put(root, map.getOrDefault(root, 0) + 1);
            }
            if(map.size() < 2)
                continue;
            
            int[] tmp = new int[2];
            int idx = 0;
            for(Integer k : set){
                tmp[idx++] = map.get(k);
            }
            
            answer = Math.min(answer, Math.abs(tmp[0] - tmp[1]));
        }
        
        return answer;
    }
    
    public void init(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
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
            parent[pb] = parent[pa];
        } else {
            parent[pa] = parent[pb];
            if(rank[pa] == rank[pb])
                rank[pb]++;
        }
    }
}