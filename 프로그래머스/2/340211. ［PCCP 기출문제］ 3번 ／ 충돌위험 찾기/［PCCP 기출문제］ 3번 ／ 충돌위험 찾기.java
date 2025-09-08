import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        int x = routes.length; // 로봇 개수
        int[][] robots = new int[x][2]; // 로봇의 현재 좌표 
        int[][] endPoints = new int[x][2]; // 각 로봇의 최종 목적지 좌표
        int[] robotIdx = new int[x];
        Set<Integer> robotSuccess = new HashSet<>(); // 로봇이 목적지에 도달했는가
        
        init(x, robotIdx, points, routes, robots, endPoints);
        
        // 모든 로봇이 목적지에 도달할 때까지
        while(robotSuccess.size() != x){            
            // 충돌 횟수 확인
            int collision = checkCollision(x, robots, robotSuccess);
            answer += collision;
            
            // 목적지에 도달한 로봇 처리
            endRobot(x, points, routes, robotIdx, robots, endPoints, robotSuccess);
            
            // 다음 칸으로 이동
            move(x, robots, endPoints, robotSuccess);
        }
        
        return answer;
    }
    
    public void init(int x, int[] robotIdx, int[][] points, int[][] routes, int[][] robots, int[][] endPoints){
        for(int i=0; i<x; i++){
            int sp = routes[i][0];
            int ep = routes[i][1];
            
            int sy = points[sp-1][0];
            int sx = points[sp-1][1];
            int ey = points[ep-1][0];
            int ex = points[ep-1][1];
            
            robots[i][0] = sy;
            robots[i][1] = sx;
            endPoints[i][0] = ey;
            endPoints[i][1] = ex;    
            
            robotIdx[i] = 1;
        }
    }   
    
    public int checkCollision(int x, int[][] robots, Set<Integer> robotSuccess){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<x; i++){
            if(robotSuccess.contains(i))
                continue;
            String s = robots[i][0] + "," + robots[i][1];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int answer = 0;
        for(String s : map.keySet()){
            if(map.get(s) > 1)
                answer++;
        }
        
        return answer;
    }
    
    public void endRobot(int x, int[][] points, int[][] routes, int[] robotIdx, int[][] robots, int[][] endPoints, Set<Integer> robotSuccess){
        for(int i=0; i<x; i++){
            int cy = robots[i][0];
            int cx = robots[i][1];
            
            int ey = endPoints[i][0];
            int ex = endPoints[i][1];
            
            int idx = robotIdx[i];
            int routeLen = routes[i].length;
            
            if(cy == ey && cx == ex){
                // 더이상 목적지가 없음
                if(idx + 1 == routeLen){
                    robotSuccess.add(i);
                } else if(idx + 1 < routeLen){
                    robotIdx[i]++;
                    int nextIdx = robotIdx[i];
                    endPoints[i][0] = points[routes[i][nextIdx] - 1][0];
                    endPoints[i][1] = points[routes[i][nextIdx] - 1][1];
                }
            }
        }
    }
    
    public void move(int x, int[][] robots, int[][] endPoints, Set<Integer> robotSuccess){
        for(int i=0; i<x; i++){
            if(robotSuccess.contains(i))
                continue;
            
            int cy = robots[i][0];
            int cx = robots[i][1];
            int ey = endPoints[i][0];
            int ex = endPoints[i][1];
            
            if(cy < ey)
                cy++;
            else if(cy > ey){
                cy--;
            } else {
                if(cx < ex)
                    cx++;
                else if(cx > ex)
                    cx--;
            }
            
            robots[i][0] = cy;
            robots[i][1] = cx;
        }
    }
}