import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(int i=0; i<phone_book.length; i++){
            String phone = phone_book[i];
            for(int j=1; j<phone.length(); j++){
                String s = phone.substring(0, j);
                if(set.contains(s)){
                    return false;
                }
            }
        }
        
        
        return answer;
    }
}