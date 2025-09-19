import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        // limit를 최대한 꽉 채워서 사람을 태우는 게 목표
        // 몸무게가 가장 큰 사람 + 그 외 1명 채우기 (Upper Bound)
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            if(people[left] + people[right] <= limit){
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        
        return answer;
    }
}