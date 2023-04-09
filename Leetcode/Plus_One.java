/*
 * 66. Plus One
 * Problem Link: https://leetcode.com/problems/plus-one
*/
class Solution {
    public int[] plusOne(int[] digits) {
        //Traversing the array from end
        for(int index=digits.length-1;index>=0;index--){
            //If value at index is less than 9, increment it and return the array.
            if(digits[index]<9){
                digits[index]++;
                return digits;
            }
            //Otherwise, that means value at index is 9 so store 0 at index.
            digits[index]=0;
        }

        //Control comes here if all the digits in array is 9,
        //So just create an array of size equal to No of digits+1.
        //Store 1 at starting index and return
        int[]plusOne=new int[digits.length+1];
        plusOne[0]=1;
        return plusOne;
    }
}