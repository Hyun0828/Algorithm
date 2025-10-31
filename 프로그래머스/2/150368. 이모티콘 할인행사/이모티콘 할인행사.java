import java.util.*;

class Solution {
    
    PriorityQueue<Point> pq = new PriorityQueue<>();
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        dfs(users, emoticons, emoticons.length, new int[emoticons.length], 0);
        
        answer[0] = pq.peek().user;
        answer[1] = pq.peek().money;
        return answer;
    }
    
    public void check(int[][] users, int[] emoticons, int[] discount){
        int gaip = 0;
        int totalSum = 0;
        
        for(int i=0; i<users.length; i++){
            int rate = users[i][0];
            int price = users[i][1];
            int sum = 0;
            for(int j=0; j<emoticons.length; j++){
                // 일정 비율 이상 할인하는 이모티콘만 구매한다.
                if(discount[j] >= rate){
                    sum += emoticons[j] * (100 - discount[j]) / 100;
                }
            }
            
            // 이모티콘 구매 비용이 price 이상이 되면, 플러스 서비스에 가입한다.
            if(sum >= price){
                gaip++;
            } else {
                totalSum += sum;
            }
        }
        
        pq.add(new Point(gaip, totalSum));
    }
    
    public void dfs(int[][] users, int[] emoticons, int m, int[] discount, int count){
        if(count == m){
            check(users, emoticons, discount);
            return;
        }
        
        for(int j=1; j<=4; j++){
            discount[count] = j * 10;
            dfs(users, emoticons, m, discount, count + 1);
        }
    }
    
    public static class Point implements Comparable<Point>{
        int user;
        int money;
        
        public Point(int user, int money){
            this.user = user;
            this.money = money;
        }
        
        @Override
        public int compareTo(Point p){
            if(this.user == p.user)
                return p.money - this.money;
            return p.user - this.user;
        }
    }
}