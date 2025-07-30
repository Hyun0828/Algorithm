import java.util.*;

class Solution {
    public String[] solution(String[] files) {        
        List<File> arr = new ArrayList<>();
        
        for(String f : files){
            File file = parseFile(f);
            arr.add(file);
        }
        
        String[] answer = new String[arr.size()];
        
        arr.sort(Comparator
                .comparing((File f) -> f.head)
                .thenComparingInt(f -> f.num));
        
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i).file;
        }
        
        return answer;
    }
    
    public File parseFile(String file){
        for(int i=0; i<file.length(); i++){
            Character c = file.charAt(i);
            if(Character.isDigit(c)){
                int j = i;
                while(j < file.length() && j - i < 5 && Character.isDigit(file.charAt(j))){
                    j++;
                }
                String head = file.substring(0, i).toUpperCase();
                int num = Integer.parseInt(file.substring(i, j));
                return new File(file, head, num);
            }
        }
        return null;
    }
    
    static class File {
        String file;
        String head;
        int num;
        
        public File(String f, String h, int n){
            this.file=f;
            this.head=h;
            this.num=n;
        }
    }
}