import java.util.*;

class Solution {
    
    static Map<Long, Set<Long>> map;
    static long sy = Long.MAX_VALUE;
    static long by = Long.MIN_VALUE;
    static long sx = Long.MAX_VALUE;
    static long bx = Long.MIN_VALUE;
    
    public String[] solution(int[][] line) {
        map = new TreeMap<>(Comparator.reverseOrder());
        int lineCount = line.length;
        combination(0, line, new HashSet<>(), 0);

        int height = (int)(by-sy+1);
        String[] answer = new String[height];
        for(int i=0; i<answer.length; i++){
            StringBuilder sb = new StringBuilder();
            
            long y = by - i;
            Set<Long> set = map.get(y);
            if(set == null){
                for(long j=sx; j<=bx; j++){
                    sb.append(".");
                }
            } else {
                for(long j=sx; j<=bx; j++){
                    if(!set.contains(j)){
                        sb.append(".");
                    } else if(set.contains(j)){
                        sb.append("*");
                    }
                }    
            }
            
            
            answer[i] = sb.toString();
        }
            
        return answer;
    }
    
    public static void check(int[][] line, Set<Integer> visited){
        int[] tmp = new int[2];
        int idx = 0;
        for(Integer num : visited){
            tmp[idx++] = num;
        }
        
        int[] line1 = line[tmp[0]];
        int[] line2 = line[tmp[1]];
        
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        
        // 두 직선이 평행한 경우
        if(a*d == b*c)
            return;
        
        long num1 = b*f-e*d;
        long num2 = e*c-a*f;
        long div = a*d-b*c;
        
        if(num1 % div == 0 && num2 % div == 0){
            long x = num1 / div;
            long y = num2 / div;
            
            sy = Math.min(sy, y);
            by = Math.max(by, y);
            sx = Math.min(sx, x);
            bx = Math.max(bx, x);
            
            map.putIfAbsent(y, new HashSet<>());
            map.get(y).add(x);
        }
    }
    
    public static void combination(int start, int[][] line, Set<Integer> visited, int count){
        if(count == 2){
            check(line, visited);
            return;
        }
        
        for(int i=start; i<line.length; i++){
            visited.add(i);
            combination(i+1, line, visited, count+1);
            visited.remove(i);
        }
    }
}