import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1;i++){
            String current = phone_book[i];
            if(phone_book[i+1].startsWith(current))
                return false;
        }
        
        return true;
    }
}