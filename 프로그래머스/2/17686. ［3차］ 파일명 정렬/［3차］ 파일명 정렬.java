import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<A> list = new ArrayList<>();
        
        for(int i=0; i<files.length; i++){
            list.add(convert(files[i], i));
        }
        Collections.sort(list);
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).file;
        }
        
        return answer;
    }
    
    public A convert(String file, int idx){
        String head="";
        int number=0;
        String tail="";
        
        for(int i=0; i<file.length(); i++){
            if(Character.isDigit(file.charAt(i))){
                head = file.substring(0, i);
                boolean isEnd = false;
                int j = i+1;
                while(j-i+1 <= 5 && j < file.length() && Character.isDigit(file.charAt(j))){
                    j++;
                }
                number = Integer.parseInt(file.substring(i, j));
                tail = file.substring(j);
                break;
                
//                 for(int j=i+1; j<file.length(); j++){
//                     if(j-i+1 > 5 && Character.isDigit(file.charAt(j))){
//                         number = Integer.parseInt(file.substring(i, j));
//                         tail = file.substring(j);
//                         isEnd = true;
//                         break;
//                     }
                    
//                     if(!Character.isDigit(file.charAt(j))){
//                         number = Integer.parseInt(file.substring(i, j));
//                         tail = file.substring(j);
//                         isEnd = true;
//                         break;
//                     }
//                 }
                
                // if(isEnd)
                //     break;
            }
        }
        return new A(file, head, number, tail, idx);
    }
    
    public static class A implements Comparable<A>{
        String file;
        String head;
        int number;
        String tail;
        int idx;
        
        public A(String file, String head, int number, String tail, int idx){
            this.file=file;
            this.head=head;
            this.number=number;
            this.tail=tail;
            this.idx=idx;
        }
        
        @Override
        public int compareTo(A a){
            if(this.head.toUpperCase().equals(a.head.toUpperCase())){
                if(this.number == a.number){
                    return this.idx - a.idx;
                } else {
                    return this.number - a.number;
                }
            } else {
                return this.head.compareToIgnoreCase(a.head);
            }
        }
    }
}