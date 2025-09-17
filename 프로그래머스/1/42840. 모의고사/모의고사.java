import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        
        for(int i=0; i<answers.length; i++){
            // 1번
            if(one(i, answers[i]))
                count1++;
            // 2번
            if(two(i, answers[i]))
                count2++;
            // 3번
            if(three(i, answers[i]))
                count3++;
        }
        int max = Math.max(Math.max(count1, count2), count3);
        if(count1 == max)
            answer.add(1);
        if(count2 == max)
            answer.add(2);
        if(count3 == max)
            answer.add(3);
        
        int[] result = new int[answer.size()];
        for(int i=0; i<result.length; i++){
            result[i] = answer.get(i);
        }
        
        return result;
    }
    
    public boolean one(int i, int answer){
        int[] tmp = new int[]{1,2,3,4,5};
        if(tmp[i%5] == answer)
            return true;
        return false;
    }
    
    public boolean two(int i, int answer){
        int[] tmp = new int[]{2,1,2,3,2,4,2,5};
        if(tmp[i%8] == answer)
            return true;
        return false;
    }
    
    public boolean three(int i, int answer){
        int[] tmp = new int[]{3,3,1,1,2,2,4,4,5,5};
        if(tmp[i%10] == answer)
            return true;
        return false;
    }
}