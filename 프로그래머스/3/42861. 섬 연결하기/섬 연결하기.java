import java.util.*;

class Solution {
    
    int[] parent;
    int[] rank;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        parent = new int[n];
        rank = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            rank[i] = 0;
        }
        
        List<Edge> edges = new ArrayList<>();
        for(int i=0; i<costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];
            
            edges.add(new Edge(from, to, weight));
        }
        Collections.sort(edges);
        
        for(Edge edge : edges){
            int from = edge.from;
            int to = edge.to;
            
            // 사이클이 없는지 판단한다.
            if(find(from) == find(to))
                continue;
            union(from, to);
            answer += edge.weight;
        }
        
        return answer;
    }
    
    public int find(int x){
        if(x == parent[x])
            return parent[x];
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int A = find(a);
        int B = find(b);
        
        if(A == B)
            return;
        
        if(rank[A] > rank[B]){
            parent[B] = A;
        } else {
            parent[A] = B;
            if(rank[A] == rank[B])
                rank[B]++;
        }
    }
    
    public static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;
        
        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }
}