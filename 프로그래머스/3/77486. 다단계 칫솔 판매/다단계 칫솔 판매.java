import java.util.*;

class Solution {
    
    // child - parent
    Map<String, String> graph = new HashMap<>();
    // 사람 - 누적 금액
    Map<String, Integer> money = new HashMap<>();
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        for(int i=0; i<enroll.length; i++){
            String child = enroll[i];
            String parent = referral[i];
            
            if(parent.equals("-")){
                graph.put(child, "center");
            } else {
                graph.put(child, parent);
            }
        }
        
        for(int i=0; i<seller.length; i++){
            dfs(seller[i], amount[i] * 100);
        }
        
        for(int i=0; i<enroll.length; i++){
            if(money.containsKey(enroll[i]))
                answer[i] = money.get(enroll[i]);
        }
        
        return answer;
    }
    
    public boolean dfs(String seller, int amount){
        if(!graph.containsKey(seller)){
            money.put(seller, money.getOrDefault(seller, 0) + amount);
            // System.out.println(seller + ", " + money.get(seller));
            return true;
        }
        
        int newAmount = (int) Math.floor(amount * 0.1);        
        money.put(seller, money.getOrDefault(seller, 0) + amount - newAmount);
        // System.out.println(seller + ", " + money.get(seller));
        if(newAmount > 0){
            if(dfs(graph.get(seller), newAmount))
                return true;
        }
        
        return false;
    }
}