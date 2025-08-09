import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
                
        // 최대공약수로 나눌 수 있는 숫자가 있으면, 최대공약수의 약수로는 반드시 나눌 수 있다.
        // 그래서 최대공약수가 안 되면 걍 안 되는거네
        
        int resultA = arrayA[0];
        int resultB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++){
            resultA = gcd(resultA, arrayA[i]);
            resultB = gcd(resultB, arrayB[i]);
        }
        
        boolean a = true;
        boolean b = true;
        
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i] % resultB == 0){
                a = false;
                break;
            }
        }
        for(int i=0; i<arrayA.length; i++){
            if(arrayB[i] % resultA == 0){
                b = false;
                break;
            }
        }
        
        if(a && !b)
            return resultB;
        if(b && !a)
            return resultA;
        if(a && b)
            return Math.max(resultA, resultB);
        
        return 0;
    }
    
    public static int gcd(int a, int b){
        while(b != 0){
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}