import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        // 특정 구간에 대해 부호가 바뀐다.
        // 수열 전체 합이 아니라 바뀐 부분 수열에 대해 최대 합을 구하는 문제
        
        // 어차피 수열이 바뀌는 케이스는 2가지 뿐인데, 1로 시작하는 경우와 -1로 시작하는 경우
        
        // 2 3 -6 1 3 -1 2 4
        // 2 -3 -6 -1 3 1 2 -4
        // -2 3 6 1 -3 -1 -2 4
        
        // -2 1 7 8 5 4 2 6
        
        int[] arr1 = new int[sequence.length];
        int[] arr2 = new int[sequence.length];
        int n1 = 1;
        int n2 = -1;
        
        for(int i=0; i<sequence.length; i++){
            arr1[i] = sequence[i] * n1;
            n1 *= -1;
            arr2[i] = sequence[i] * n2;
            n2 *= -1;
        }
        
        return Math.max(solve(arr1), solve(arr2));
    }

    public long solve(int[] arr){
        long max = arr[0];
        long current = arr[0];
        
        for(int i=1; i<arr.length; i++){
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }
        
        return max;
    }
}