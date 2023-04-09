/*
 * 58. Length of Last word
 * Problem Link: https://leetcode.com/problems/length-of-last-word/description/
 * Algorithm: -
*/
class Solution {
    public int lengthOfLastWord(String s) {
        //Removing spaces from last and storing in another variable
        String inputString = s.trim();
        int LengthOfLastWord=0;
        //Looping through all characters of inputSTring from last
        for(int index=inputString.length()-1;index>=0;index--){
            //when space character is encountered return the length 
            if(inputString.charAt(index)==' ')
                return LengthOfLastWord;
            //Increment LengthOfLastWord if charcter is not empty(' ')
            LengthOfLastWord++;
        }
        return LengthOfLastWord;
    }
}