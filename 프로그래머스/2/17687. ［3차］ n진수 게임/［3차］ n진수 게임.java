import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        
        int num = 0; // 차례로 올라가는 십진수
        int order = 1; // 몇 번째 사람이 대답할 차례인지
        
        while (true) {
            String s = Integer.toString(num, n);
            for (char c : s.toCharArray()){
                if (order == p) {
                    if (Character.isLowerCase(c)){
                        c = Character.toUpperCase(c);
                    }
                    sb.append(c);
                    t--;
                    if (t==0){
                        return sb.toString();
                    }
                }
                order += 1;
                if (order > m) {
                    order=1;
                } 
            }
            num++;
        }
    }
}