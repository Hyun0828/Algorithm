import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        int len = friends.length;
        Map<String, Integer> map = new LinkedHashMap<>();
        int[][] arr = new int[len][len];
        int[] score = new int[len];
        
        int[] gift = new int[len];
    
        // friends 이름을 0,1,2,3,4... 로 매핑
        for(int i=0; i<len; i++)
            map.put(friends[i], i);
        
        // gifts 배열을 통해 표 생성
        for(int i=0; i<gifts.length; i++){
            String[] s = gifts[i].split(" ");
            
            String friend1 = s[0];
            String friend2 = s[1];
            
            int n1 = map.get(friend1);
            int n2 = map.get(friend2);
            
            arr[n1][n2] += 1;
        }
        
        // 선물 지수 표 생성
        for(int i=0; i<len; i++){
            
            int get = 0;
            int give = 0;
            for(int j=0; j<len; j++){
                get += arr[i][j];
                give += arr[j][i];
            }
            
            score[i] = get - give;
        }
        
        // 문제 풀기
        for(int i=0; i<len - 1; i++){
            for(int j=i+1; j<len; j++){
                String friend1 = friends[i];
                String friend2 = friends[j];
                
                int n1 = map.get(friend1);
                int n2 = map.get(friend2);
                
                if(arr[n1][n2] > arr[n2][n1]){
                    gift[n1] += 1;
                } else if(arr[n1][n2] < arr[n2][n1]){
                    gift[n2] += 1;
                } else {
                    if(score[n1] > score[n2]){
                        gift[n1] += 1;
                    } else if(score[n1] < score[n2]){
                        gift[n2] += 1;
                    }
                }
            }
        }
        
        Arrays.sort(gift);
        
        if(gift[len-1] != 0)
            return gift[len-1];
        else
            return 0;
    }
}