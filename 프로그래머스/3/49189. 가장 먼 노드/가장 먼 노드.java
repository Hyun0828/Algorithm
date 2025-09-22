import java.util.*;

class Solution {
    Map<Integer, List<Integer>> graph;
    int[] distance;
    
    public int solution(int n, int[][] edge) {
        int answer = 1;
        
        graph = new HashMap<>();
        distance = new int[n+1];
        for(int i=0; i<edge.length; i++){
            int from = edge[i][0];
            int to = edge[i][1];
            
            graph.putIfAbsent(from, new ArrayList<>());
            List<Integer> list = graph.get(from);
            list.add(to);
            
            graph.putIfAbsent(to, new ArrayList<>());
            List<Integer> tmp = graph.get(to);
            tmp.add(from);
        }
        dijkstra(n);
        Arrays.sort(distance);
        int max = distance[distance.length-1];
        for(int i=distance.length-2; i>=0; i--){
            if(max == distance[i])
                answer++;
            else
                break;
        }
        
        return answer;
    }
    
    public void dijkstra(int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        
        for(int i=1; i<=n; i++)
            distance[i] = 100000;
        distance[1] = 0;
        
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int node = cur[0];
            int dis = cur[1];
            
            if(dis > distance[node])
                continue;
            
            if(!graph.containsKey(node))
                continue;
            
            List<Integer> edges = graph.get(node);
            for(Integer to : edges){
                if(distance[to] > distance[node] + 1){
                    distance[to] = distance[node] + 1;
                    pq.add(new int[]{to, distance[to]});
                }
            }
        }
    }
}