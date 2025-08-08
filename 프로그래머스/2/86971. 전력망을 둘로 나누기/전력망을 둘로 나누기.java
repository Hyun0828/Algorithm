import java.util.*;

class Solution {
    
    static int[] parent;
    static int[] rank;
    
    public int solution(int n, int[][] wires) {
        int answer = 10000000;
        
        for(int i=0; i<wires.length; i++){
            init(n);
            
            for(int j=0; j<wires.length; j++){
                if(i==j)
                    continue;
                int v1 = wires[j][0];
                int v2 = wires[j][1];
                
                union(v1, v2);
            }
            
            // 트리가 2개인 지 + 두 트리의 송전탑 개수 비교
            Map<Integer, Integer> map = new HashMap<>();
            for(int k=1; k<=n; k++){
                int root = find(k);
                map.put(root, map.getOrDefault(root, 0) + 1);
            }
            
            if(map.keySet().size() == 2){
                Iterator<Integer> iter = map.keySet().iterator();
                int count1 = map.get(iter.next());
                int count2 = map.get(iter.next());
                
                answer = Math.min(answer, Math.abs(count1 - count2));
            }
        }
        
        return answer;
    }
    
    public static void init(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        
        for(int i=1; i<=n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }
    
    public static int find(int x){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
    
    public static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        
        if(parentA == parentB)
            return;
        
        if(rank[parentA] > rank[parentB])
            parent[parentB] = parentA;
        else{
            parent[parentA] = parentB;
            if(rank[parentA] == rank[parentB]){
                rank[parentB]++;
            }
        }
    }
}