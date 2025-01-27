import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int[] solution(String s) {
        List<String> results = this.extractContents(s);
        Partition[] tuples = new Partition[results.size()];
        
        for(int i=0; i<results.size(); i++){
            Partition partition = createPartition(results.get(i));
            tuples[i] = partition;
        }
        Arrays.sort(tuples);
        
        return getRealTuple(tuples);
    }
    
    public int[] getRealTuple(Partition[] tuples){
        List<Integer> realTuple = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<tuples.length; i++){
            int[] arr = tuples[i].getArr();
            for(int j=0; j<arr.length; j++){
                if(!set.contains(arr[j])){
                    realTuple.add(arr[j]);
                    set.add(arr[j]);
                }
            }
        }
        
        return realTuple.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    public List<String> extractContents(String input) {
        List<String> contents = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\{([^{}]+)\\}");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            contents.add(matcher.group(1));
        }
        return contents;
    }
    
    public Partition createPartition(String input){
        String[] temp = input.split(",");
        int length = temp.length;
        
        int[] arr = new int[length];
        for(int i=0; i<length; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        
        return new Partition(arr, length);
    }
    
    public static class Partition implements Comparable<Partition>{
        private int[] arr;
        private int length;
        
        public Partition(){
            
        }
        
        public Partition(int[] arr, int length){
            this.arr = arr;
            this.length= length;
        }
        
        public int[] getArr(){
            return Arrays.copyOf(this.arr, this.arr.length);
        }
        
        public int getLength(){
            return this.length;
        }
        
        @Override
        public int compareTo(Partition other){
            return Integer.compare(this.length, other.length);
        }
    }
}