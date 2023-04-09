/*
 * 171. Excel Sheet Column Number
 * Problem Link: https://leetcode.com/problems/excel-sheet-column-number/
 * Algorithm: -
*/
class Solution {
    public int titleToNumber(String columnTitle) {
        //If we clearly observe the columnNumber and columnTitle,columnTitle resembles Base-26 Number System.
        // So our job is to convert Value in Base-26 Number System to Decimal Number System        
        //Initially the power is 1 (26^0=1)
        int pow=1;
        int columnNumber=0;
        for(int index=columnTitle.length()-1;index>=0;index--){
            //Determining the character value in Base-26 Number System
            int charValue=columnTitle.charAt(index)-'A'+1;
            columnNumber+=charValue*pow;
            pow*=26;
        }
        return columnNumber;
    }
}