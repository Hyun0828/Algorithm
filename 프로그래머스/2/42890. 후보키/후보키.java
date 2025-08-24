import java.util.*;

class Solution {
    
    static Set<String> cKeys;
    
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        cKeys = new HashSet<>();
        
        for(int i=1; i<=columnCount; i++){
            dfs(relation, columnCount, new HashSet<>(), i, 0);
        }
        
        return cKeys.size();
    }
    
    public static void isUnique(String[][] relation, Set<Integer> visited){   
        StringBuilder sb = new StringBuilder();
        for(Integer k : visited){
            sb.append(k);
        }
        String s = sb.toString();

        // 123(s)인데 13(key)이 후보키면 이런 케이스를 걸러내지 못함.
        // for(String key : cKeys){
            // if(s.contains(key)){
                // return; 
            // }
        // }
        
        for (String key : cKeys) {
            boolean isSubset = true;
            for (int i = 0; i < key.length(); i++) {
                if (!s.contains(String.valueOf(key.charAt(i)))) {
                    isSubset = false;
                    break;
                }
            }
            if (isSubset) return; 
        }
        
        Set<String> set = new HashSet<>();
        for(int i=0; i<relation.length; i++){
            String[] record = relation[i];
            String temp = "";
            for(int j=0; j<record.length; j++){
                if(visited.contains(j)){
                    temp += record[j];
                }
            }
            // 유일성을 만족하지 못하면
            if(set.contains(temp))
                return;
            set.add(temp);
        }
        
        // 유일성을 만족하는 키면 후보키에 등록한다.
        cKeys.add(s);
    }
    
    public static void dfs(String[][] relation, int columnSize, Set<Integer> visited, int n, int count){
        if(count == n){
            // 유일성 만족 조건 확인
            isUnique(relation, visited);
        }
        
        for(int i=0; i<columnSize; i++){
            if(!visited.contains(i)){
                visited.add(i);
                dfs(relation, columnSize, visited, n, count + 1);
                visited.remove(i);
            }
        }
    }
}