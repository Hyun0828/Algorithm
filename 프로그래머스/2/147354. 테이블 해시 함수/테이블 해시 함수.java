import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        List<Record> table = new ArrayList<>();
        for(int i=0; i<data.length; i++){
            int[] num = data[i];
            table.add(new Record(num, num[0], num[col-1]));
        }
        
        table.sort(Comparator.comparingInt((Record p) -> p.level)
                   .thenComparing(Comparator.comparingInt((Record p) -> p.pk).reversed()));
        
        List<Integer> arr = new ArrayList<>();
        for(int i=row_begin; i<=row_end; i++){
            Record record = table.get(i-1);
            int sum = 0;
            for(int j=0; j<record.num.length; j++){
                sum += record.num[j] % i;
            }
            arr.add(sum);
        }
        
        for(int i=0; i<arr.size(); i++){
            answer = answer ^ arr.get(i);
        }
        
        return answer;
    }
    
    public static class Record {
        int[] num;
        int pk;
        int level;
        
        public Record(int[] num, int pk, int level){
            this.num = num;
            this.pk = pk;
            this.level = level;
        }
    }
}