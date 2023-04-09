/*
 * 168. Excel Sheet Column Title
 * Problem Link: https://leetcode.com/problems/excel-sheet-column-title/
 * Algorithm: -
*/
class Solution {
    public String convertToTitle(int columnNumber) {
        //Using StringBuilder Instead of String Class, String Concatenation takes more time and 
        //everytime when we concatenate, a new string will be created which increase time.
        StringBuilder string=new StringBuilder();
        while(columnNumber!=0){
            //Usually a Number System's range is (0-r), as columnNumber resembling base-26 Number system but it range is(1-26).
            //Decrementing the value o compensate
            columnNumber--;

            //as the columnNumber is in base-26 Number System, performing modulo operation with 26 to get lastCharacter
            int lastCharAscii=columnNumber%26;
            char lastChar=(char)(lastCharAscii+'A');
            string.append(lastChar);
            columnNumber=columnNumber/26;
        }
        return string.reverse().toString();
    }
}