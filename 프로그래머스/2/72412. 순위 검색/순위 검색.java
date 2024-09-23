import java.util.*;

class Solution {
    
    Map<String, ArrayList<Integer>> people = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        int idx = 0;
        
        for(int i=0; i<info.length; i++){
            String[] temp = info[i].split(" ");
            String[] S1 = {temp[0], "-"};
            String[] S2 = {temp[1], "-"};
            String[] S3 = {temp[2], "-"};
            String[] S4 = {temp[3], "-"};
            int score = Integer.parseInt(temp[4]);
            
            for(String s1 : S1){
                for(String s2 : S2){
                    for(String s3 : S3){
                        for(String s4 : S4){
                            String[] s = {s1, s2, s3, s4};
                            String key = String.join("", s);
                            ArrayList<Integer> arr = people.getOrDefault(key, new ArrayList<Integer>());
                            arr.add(score);
                            people.put(key, arr);
                        }
                    }
                }
            }
        }
        
        for(ArrayList<Integer> value : people.values())
            value.sort(null);
        
        for(int i=0; i<query.length; i++){
            String[] temp = query[i].split(" and ");
            int score = Integer.parseInt(temp[3].split(" ")[1]);
            temp[3] = temp[3].split(" ")[0];
            String key = String.join("", temp);
            
            if(people.containsKey(key)){
                ArrayList<Integer> value = people.get(key);
                
                int left = 0;
                int right = value.size();
                while(left < right){
                    int mid = (left+right)/2;
                    if(value.get(mid) < score)
                        left = mid + 1;
                    else
                        right = mid;
                }
                answer[idx++] = value.size() - right;
            } else {
                answer[idx++] = 0;
            }
        }
        
        return answer;
    }
}