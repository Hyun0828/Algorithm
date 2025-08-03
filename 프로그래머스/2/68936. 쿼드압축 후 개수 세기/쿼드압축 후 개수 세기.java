import java.util.*;

class Solution {
    
    static int n;
    static int[] answer;
    
    public int[] solution(int[][] arr) {
        int size = arr.length;
        n = arr.length;
        answer = new int[2];
        
        solve(arr, 0, 0, size);
        
        return answer;
    }
    
    public static void solve(int[][] arr, int y, int x, int size){
        if(y < 0 || y > n || x < 0 || x > n){
            return;
        }
        
        // 같으면 개수 세기
        if(find(arr,y,x,size)) {
            answer[arr[y][x]] += 1;
            return;
        }
        
        solve(arr, y, x, size / 2);
        solve(arr, y + size / 2, x, size / 2);
        solve(arr, y, x + size / 2, size / 2);
        solve(arr, y + size / 2, x + size / 2, size / 2);
    }
    
    public static boolean find(int[][] arr, int y, int x, int size){
        int num = arr[y][x];
        for(int i=y; i<y+size; i++){
            for(int j=x; j<x+size; j++){
                if(num != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}