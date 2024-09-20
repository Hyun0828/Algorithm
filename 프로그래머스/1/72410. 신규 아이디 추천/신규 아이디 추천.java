import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        char[] arr = new_id.toCharArray();
        List<Character> id = new LinkedList<>();
        
        for(char c : arr){
            id.add(c);
        }
        
        // step1
        for(int i=0; i<id.size(); i++){
            if(Character.isUpperCase(id.get(i)))
                id.set(i, Character.toLowerCase(id.get(i)));
        }
        
        // step2
        for(int i=0; i<id.size(); i++){
            if(Character.isLowerCase(id.get(i)) || Character.isDigit(id.get(i)) || id.get(i) == '-' || id.get(i) == '_' || id.get(i) == '.')
                continue;
            else{
                id.remove(i);
                i--;
            }
        }
        
        // step3
        for(int i=0; i<id.size()-1; i++){
            if(id.get(i) == '.' && id.get(i+1) == '.'){
                id.remove(i);
                i--;
            }
        }
        
        // step4
        if(id.get(0)=='.')
            id.remove(0);
        if(id.size() > 0)
            if(id.get(id.size()-1)=='.')
                id.remove(id.size()-1);
        
        // step5
        if(id.isEmpty())
            id.add('a');
        
        // step6
        if(id.size() >= 16){
            for(int i=15; i<id.size(); i++){
                id.remove(i);
                i--;
            }
        }
        if(id.get(id.size()-1)=='.')
            id.remove(id.size()-1);
        
        // step7
        if(id.size() <= 2){
            while(id.size() != 3){
                id.add(id.get(id.size()-1));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<id.size(); i++){
            sb.append(id.get(i));
        }
        answer = sb.toString();
        return answer;
    }
}