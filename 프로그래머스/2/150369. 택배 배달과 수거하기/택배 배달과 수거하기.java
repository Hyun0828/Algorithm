import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Home> dStack = new Stack<>();
        Stack<Home> pStack = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(deliveries[i] > 0)
                dStack.push(new Home(i+1, deliveries[i]));
            if(pickups[i] > 0 )
                pStack.push(new Home(i+1, pickups[i]));
        }
        
        while(!dStack.isEmpty() || !pStack.isEmpty()){
            int endHomeNumber = 0; // 어쨌든 최종 목적지 집 번호
            if(!dStack.isEmpty()){
                endHomeNumber = Math.max(endHomeNumber, dStack.peek().homeNumber);   
            }
            if(!pStack.isEmpty()){
                endHomeNumber = Math.max(endHomeNumber, pStack.peek().homeNumber);
            }
            // System.out.println("가장 먼 집 : " + endHomeNumber);
            answer += endHomeNumber * 2; // 일단 여기까진 가야함 (왕복)
            
            // 택배 배달하기
            int putCount = 0;
            while(!dStack.isEmpty()){
                if(cap >= putCount + dStack.peek().count){
                    // System.out.println("택배 배달 : " + dStack.peek().homeNumber);
                    putCount += dStack.peek().count;
                    dStack.pop();
                } else if(cap < putCount + dStack.peek().count){
                    // System.out.println("택배 배달 : " + dStack.peek().homeNumber);
                    Home h = dStack.pop();
                    h.count -= (cap - putCount);
                    dStack.push(h);
                    putCount = cap;
                }
                
                if(putCount == cap)
                    break;
            }
            // 택배 수거하기
            int getCount = 0;
            while(!pStack.isEmpty()){
                // 수거가 가능하면
                if(pStack.peek().count <= cap - getCount){
                    // System.out.println("택배 수거 : " + pStack.peek().homeNumber);
                    getCount += pStack.peek().count;
                    pStack.pop();
                } else {
                    Home h = pStack.pop();
                    h.count -= (cap - getCount);
                    pStack.push(h);
                    getCount = cap;
                }
                
                if(getCount == cap)
                    break;
            }
        }
        
        return answer;
    }
    
    public static class Home {
        int homeNumber;
        int count;
        
        public Home(int homeNumber, int count){
            this.homeNumber = homeNumber;
            this.count = count;
        }
    }
}