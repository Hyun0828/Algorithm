import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // userId - Name
        Map<String, String> userMap = new HashMap<>();
        List<History> list = new ArrayList<>();
        
        for(String s : record){
            String[] t = s.split(" ");
            if(t[0].equals("Enter")){
                userMap.put(t[1], t[2]);
                list.add(new History(true, t[1]));
            } else if(t[0].equals("Leave")){
                list.add(new History(false, t[1]));
            } else if(t[0].equals("Change")){
                userMap.put(t[1], t[2]);
            }
        }
        
        String[] answer = new String[list.size()];
        for(int i=0; i<answer.length; i++){
            String name = userMap.get(list.get(i).userId);
            if(list.get(i).isEnter){
                answer[i] = name + "님이 들어왔습니다.";
            } else {
                answer[i] = name + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
    
    public static class History {
        boolean isEnter;
        String userId;
        
        public History(boolean isEnter, String userId){
            this.isEnter = isEnter;
            this.userId = userId;
        }
    }
}