import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Book[] books = new Book[book_time.length];
        for(int i=0; i<book_time.length; i++){
            books[i] = new Book(convert(book_time[i][0]), convert(book_time[i][1]));
        }
        Arrays.sort(books, (a,b) -> a.start - b.start);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Book book : books){
            if(!pq.isEmpty() && pq.peek() <= book.start)
                pq.poll();
            pq.offer(book.end + 10);
        }
        
        return pq.size();
    }
    
    public static int convert(String time){
        String[] s = time.split(":");
        return Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
    }
    
    public static class Book {
        int start;
        int end;
        
        public Book(int s, int e){
            start = s;
            end = e;
        }
    }
}