/*
 * 48. Rotate Image
 * Problem Link: https://leetcode.com/problems/rotate-image/
 * Algorithm: -
 * Time Complexity:O(N^2)
 * Space Complexity:O(1)
*/
class Solution {
    public void rotate(int[][] matrix) {
        //Transpose the matrix
        transposeMatrix(matrix);
        //It will reverse all rows
        reverseRows(matrix);
    }
    private void transposeMatrix(int[][] matrix){
        //Determining number of rows and columns of matrix
        int rows = matrix.length, cols = matrix[0].length;

        //Looping all rows of matrix
        for(int i=0;i<rows;i++){
            //Looping all columns of matrix
            for(int j=0;j<cols;j++){
                //if row number and column number is same breaking the loop
                if(i==j)
                    break;
                //swapping symmetrix elements 
                swap(i,j,j,i,matrix);
            }
        }
    }
    private void reverseRows(int[][] matrix){
        //Determining number of rows and columns of matrix
        int rows = matrix.length, cols = matrix[0].length;

        //Looping all rows of matrix
        for(int index=0;index<rows;index++){
            //Creating two pointers low and high
            //low points to element at (index,low) and high points to (index,high)
            int low=0,high=cols-1;

            //Runnning a while loop untill low<high
            while(low<high){
                //Swapping elements pointed by low and high
                swap(index,low,index,high,matrix);
                //Incrementing low 
                low++;
                //Decrementig high
                high--;
            }
        }
    }
    private void swap(int xi,int xj,int yi,int yj,int[][] matrix){
        int temp=matrix[xi][xj];
        matrix[xi][xj] = matrix[yi][yj];
        matrix[yi][yj] = temp;
    }
}