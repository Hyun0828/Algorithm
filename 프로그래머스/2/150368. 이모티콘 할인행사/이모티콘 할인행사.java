class Solution {
    
    int[] arr;
    int subscribe = 0;
    int price = 0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        arr = new int[emoticons.length];
        
        DFS(0, users, emoticons);
        
        int[] answer = {subscribe, price};
        return answer;
    }
    
    private void DFS(int idx, int[][] users, int[] emoticons){
        
        if(idx == emoticons.length){
            calculate(users, emoticons);
            return;
        }
        
        for(int i=10; i<=40; i+=10){
            arr[idx] = i;
            DFS(idx+1, users, emoticons);
        }
    }
    
    private void calculate(int[][] users, int[] emoticons){
        int count = 0;
        int money = 0;
        
        for(int i=0; i<users.length; i++){
            int user_percent = users[i][0];
            int user_price = users[i][1];
            int sum = 0;
            
            for(int j=0; j<arr.length; j++){
                if(user_percent <= arr[j]){
                    sum += emoticons[j] * (1-arr[j]*0.01);    
                }
            }
            
            if(user_price <= sum)
                count++;
            else
                money+=sum;
        }
        
        if(subscribe < count){
            subscribe = count;
            price = money;
            return;
        } else if(subscribe == count){
            if(price < money)
                price = money;
        }
    }
}