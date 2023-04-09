/*
 * 73. Set Matrix Zeroes
 * Problem Link: https://leetcode.com/problems/set-matrix-zeroes/
 * Algorithm: -
 * Time Complexity:O(N^2)
 * Space Complexity:O(1)//Usually we will not consider result array or list while calculating space complexity
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        //Finding rows and cols of matrix
        int rows=matrix.length,cols=matrix[0].length;
        //using firstRow to store 1 if first row has atleast one zero 
        int firstRow=0;
        //Looping first row for zeroes
        for(int j=0;j<cols;j++){
            if(matrix[0][j]==0){
                firstRow=1;
                break;
            }
        }
        //Using first row and first col to check whether atleat one zero present in their resp rows and cols
        for(int i=1;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //Again looping matrix from end and for a cell if it has zero in its row or column, make that cell zero
        for(int i=rows-1;i>=1;i--){
            for(int j=cols-1;j>=0;j--){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        //Looping first row seperately
        if(firstRow==1){
            for(int j=0;j<cols;j++){
                matrix[0][j]=0;
            }
        }
    }
}