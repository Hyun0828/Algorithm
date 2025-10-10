import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Room> list = new ArrayList<>();
        
        for(int i=0; i<book_time.length; i++){
            String[] b = book_time[i];
            int enter = convert(b[0]);
            int leave = convert(b[1]);
            list.add(new Room(enter, leave));
        }
        Collections.sort(list);
        
        answer++;
        pq.add(list.get(0).leave);
        for(int i=1; i<list.size(); i++){
            Room room = list.get(i);
            
            if(!pq.isEmpty()){
                if(pq.peek()+10 <= room.enter){
                    pq.poll();
                } else {
                    answer++;
                }
                pq.add(room.leave);
            }
        }
        
        return answer;
    }
    
    public int convert(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
    
    public static class Room implements Comparable<Room> {
        int enter;
        int leave;
        
        public Room(int enter, int leave){
            this.enter = enter;
            this.leave = leave;
        }
        
        @Override
        public int compareTo(Room r){
            return this.enter - r.enter;
        }
    }
}