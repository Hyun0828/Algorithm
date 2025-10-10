import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for(int i=1; i<arrayA.length; i++){
            gcdA = gcd(gcdA, arrayA[i]);
        }
        for(int i=1; i<arrayB.length; i++){
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        boolean aPossible = true;
        boolean bPossible = true;
        for(int i=0; i<arrayA.length; i++){
            if(arrayA[i] % gcdB == 0){
                bPossible = false;
                break;
            }
        }
        for(int i=0; i<arrayB.length; i++){
            if(arrayB[i] % gcdA == 0){
                aPossible = false;
                break;
            }
        }
        
        if(aPossible && bPossible)
            return Math.max(gcdA, gcdB);
        if(aPossible)
            return gcdA;
        if(bPossible)
            return gcdB;
        return 0;
    }
    
    public int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}