import java.util.*;

class Solution {
    
    PriorityQueue<Edge> pq = new PriorityQueue<>();
    int[] rank;
    int[] parent;
    Set<Integer> nodes = new HashSet<>();
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        rank = new int[n];
        parent = new int[n];
        
        for(int i=0; i<n; i++){
            rank[i] = 0;
            parent[i] = i;
        }
        
        for(int i=0; i<costs.length; i++){
            pq.add(new Edge(costs[i][0], costs[i][1], costs[i][2]));
        }
        
        while(nodes.size() <= n && !pq.isEmpty()){
            Edge edge = pq.poll();
            int from = edge.from;
            int to = edge.to;
            
            // cycle 생김
            if(find(from) == find(to))
                continue;
            
            union(from, to);
            nodes.add(from);
            nodes.add(to);
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
        int A = parent[a];
        int B = parent[b];
        
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
    
    public static class Edge implements Comparable<Edge> {
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