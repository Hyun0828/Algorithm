import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int health_time = 1; // 연속 성공 시간
        int play_time = attacks[attacks.length - 1][0]; // 총 플레이 시간 (괴물의 마지막 공격)
        int current_health = health; // 현재 체력
        
        for(int i=1; i<=play_time; i++){
            
            boolean isAttacked = false;
            
            for(int j=0; j<attacks.length; j++){
                // 몬스터의 공격이 있을 때
                if(i == attacks[j][0]){
                    isAttacked = true;
                    health_time = 0;
                    current_health -= attacks[j][1];
                    break;
                }
            }
            
            // 몬스터의 공격이 없을 때
            if(!isAttacked){
                health_time++;
                
                // t초 연속 회복했을 때
                if(health_time == bandage[0]){
                    current_health = current_health + bandage[1] + bandage[2];
                    health_time = 0;
                }
                // t초 연속 회복이 아닐 때
                else
                    current_health = current_health + bandage[1];
                // 최대 체력 이상의 체력을 가질 수 없다.
                if(current_health > health)
                    current_health = health;    
            }
            
            System.out.println(current_health + ", " + health_time);
            
            
            if(current_health <= 0){
                current_health = -1;
                break;
            }
        }
        
        return current_health;
    }
}