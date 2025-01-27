class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {        
        int x = arr1.length;
        int y = arr1[0].length;
        int z = arr2[0].length;
        
        int[][] answer = new int[x][z];
        // xy, yz -> xz
        
        for(int i=0; i<x; i++){
            for(int j=0; j<z; j++){
                int value = 0;
                for(int k=0; k<y; k++){
                    value += (arr1[i][k] * arr2[k][j]);
                }
                answer[i][j] = value;
            }
        }
        
        return answer;
    }
}