/*
 * 74. Search a 2D Matrix
 * Problem Link: https://leetcode.com/problems/search-a-2d-matrix/
 * Algorithm: Binary Search
 * Time Complexity:O(log(M*N))
 * Space Complexity:O(1)
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //finding no. of rows and no. of cols of matrix array
        int rows=matrix.length,cols=matrix[0].length;
        //creating two pointers, start will be pointing to first cell of matrix and end will be pointing to last element of cell
        int start=0,end=(rows*cols)-1;
        //running a loop until start<end
        while(start<=end){
            //find the mid 
            int mid=start+((end-start)/2);
            //calculating the row index and column index of mid
            int midRow=mid/cols,midCol=mid%cols;
            //Checking whether element at mid is equal to target, if Yes return ing true
            if(matrix[midRow][midCol]==target){
                return true;
            //if element at mid is less than target, then changing the value of end to mid-1
            }else if(target<matrix[midRow][midCol]){
                end=mid-1;
            //if element at mid is greater than target, then changing the value of start to mid+1
            }else{
                start=mid+1;
            }
        }
        //If control goes out of the loop that means target is not present in matrix, so returning false
        return false;
    }
}