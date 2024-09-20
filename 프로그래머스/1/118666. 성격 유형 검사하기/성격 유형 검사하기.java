import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        Map<Character, Integer> point = new HashMap<>();
        
        for(int i=0; i<survey.length; i++){
            char[] temp = survey[i].toCharArray();
            char noAgree = temp[0]; // A
            char Agree = temp[1]; // N
            int choice = choices[i]; // 5
            
            if(choice >=1 && choice <=3)
                point.put(noAgree, point.getOrDefault(noAgree, 0) + (4-choice));
            else if(choice >= 5 && choice <=7)
                point.put(Agree, point.getOrDefault(Agree, 0) + (choice-4));
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 'R' vs 'T'
        if (point.getOrDefault('R', 0) < point.getOrDefault('T', 0)) {
            sb.append('T');
        } else {
            sb.append('R');
        }

        // 'C' vs 'F'
        if (point.getOrDefault('C', 0) < point.getOrDefault('F', 0)) {
            sb.append('F');
        } else {
            sb.append('C');
        }

        // 'J' vs 'M'
        if (point.getOrDefault('J', 0) < point.getOrDefault('M', 0)) {
            sb.append('M');
        } else {
            sb.append('J');
        }

        // 'A' vs 'N'
        if (point.getOrDefault('A', 0) < point.getOrDefault('N', 0)) {
            sb.append('N');
        } else {
            sb.append('A');
        }
        
        answer = sb.toString();
        return answer;
    }
}