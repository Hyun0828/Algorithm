import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder ans = new StringBuilder();
        
        // 숫자 위치 좌표 저장
        Map<Integer, Point> keyPad = new HashMap<>();
        keyPad.put(0, new Point(4, 2));
        for(int i=1; i<=3; i++)
            keyPad.put(i, new Point(1, i));
        for(int i=4; i<=6; i++)
            keyPad.put(i, new Point(2, i-3));
        for(int i=7; i<=9; i++)
            keyPad.put(i, new Point(3, i-6));

        // 왼손 오른손 엄지 위치 저장
        Point left = new Point(4,1);
        Point right = new Point(4,3);
        
        // 계산
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                ans.append("L");
                left = keyPad.get(numbers[i]);
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                ans.append("R");
                right = keyPad.get(numbers[i]);
            }
            else{
                Point number = keyPad.get(numbers[i]);
                int left_distance = Math.abs(number.x - left.x) + Math.abs(number.y - left.y);
                int right_distance = Math.abs(number.x - right.x) + Math.abs(number.y - right.y);
                
                if(left_distance == right_distance){
                    if(hand.equals("left")){
                        ans.append("L");
                        left = keyPad.get(numbers[i]);
                    }
                    else if(hand.equals("right")){
                        ans.append("R");
                        right = keyPad.get(numbers[i]);
                    }
                } else if(left_distance < right_distance){
                    ans.append("L");
                    left = keyPad.get(numbers[i]);          
                } else if(left_distance > right_distance){
                    ans.append("R");
                    right = keyPad.get(numbers[i]);
                }
            }
            
            System.out.println("left " + left.x + " " + left.y);
            System.out.println("right " + right.x + " " + right.y);
            System.out.println("--------");
        }
        
        answer = ans.toString();
        return answer;
    }
}

class Point {
    int x;
    int y;
    
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}