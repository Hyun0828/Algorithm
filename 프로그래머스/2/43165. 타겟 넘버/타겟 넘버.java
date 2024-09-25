class Solution {
    
    int answer = 0;
    public int solution(int[] numbers, int target) {
        
        char[] arr = new char[numbers.length]; // +, -를 순서대로 저장한다.
        DFS(0, arr, numbers, target);
        
        return answer;
    }
    
    private int calculate(char[] arr, int[] numbers){
        int sum = 0;
        
        for(int i=0; i<numbers.length; i++){
            if(arr[i] == '+')
                sum += numbers[i];
            else if(arr[i] == '-')
                sum -= numbers[i];
        }
        
        return sum;
    }
    
    private void DFS(int idx, char[] arr, int[] numbers, int target){
        
        if(idx == numbers.length){
            if(calculate(arr, numbers) == target)
                answer++;
            return;
        }
        
        for(int i=0; i<2; i++){
            if(i==0){
                arr[idx] = '+';
                DFS(idx+1, arr, numbers, target);
            }
            else{
                arr[idx] = '-';
                DFS(idx+1, arr, numbers, target);
            }
        }
        
    }
}