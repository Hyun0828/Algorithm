import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        
        List<Integer> idx_list = new LinkedList<>();
        
        int int_ext = 0;
        if(ext.equals("code"))
            int_ext = 0;
        else if(ext.equals("date"))
            int_ext = 1;
        else if(ext.equals("maximum"))
            int_ext = 2;
        else if(ext.equals("remain"))
            int_ext = 3;
        
        int idx_sort = 0;
        if(sort_by.equals("code"))
            idx_sort = 0;
        else if(sort_by.equals("date"))
            idx_sort = 1;
        else if(sort_by.equals("maximum"))
            idx_sort = 2;
        else if(sort_by.equals("remain"))
            idx_sort = 3;
        
        
        // 해당하는 배열의 idx들 저장
        for(int i=0; i<data.length; i++)
            if(data[i][int_ext] < val_ext)
                idx_list.add(i);    
        
        // 추출
        answer = new int[idx_list.size()][4];
        for(int i=0; i<idx_list.size(); i++)
            answer[i] = data[idx_list.get(i)];
        
        // 정렬
        for(int i=0; i<idx_list.size()-1; i++){
            int tmp = i;
            for(int j=i+1; j<idx_list.size(); j++){
                if(answer[tmp][idx_sort] >= answer[j][idx_sort])
                    tmp = j;
            }
            
            int[] temp = answer[tmp];
            answer[tmp] = answer[i];
            answer[i] = temp;
        }
        
        
        return answer;
    }
}