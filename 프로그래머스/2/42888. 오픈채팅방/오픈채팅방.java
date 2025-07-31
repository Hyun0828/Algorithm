import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        Map<String, String> nameMap = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter"))
                nameMap.put(s[1], s[2]);
            if(s[0].equals("Change"))
                nameMap.put(s[1], s[2]);
        }
        
        for(int i=0; i<record.length; i++){
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter"))
                answer.add(nameMap.get(s[1]) + "님이 들어왔습니다.");
            else if(s[0].equals("Leave"))
                answer.add(nameMap.get(s[1]) + "님이 나갔습니다.");
            else
                continue;
        }
        
        String[] temp = new String[answer.size()];
        for(int i=0; i<answer.size(); i++){
            temp[i] = answer.get(i);
        }
        return temp;
    }
}