/*
 * 125. Valid Palindrome
 * Problem Link: https://leetcode.com/problems/valid-palindrome/description/
*/
class Solution {
    public boolean isPalindrome(String s) {
        //Creting two pointers which will point to starting and ending of string
        int start=0,end=s.length()-1;
        while(start<end){
            //Storing characters pointed by start and end pointers in two variables
            Character charAtStart=s.charAt(start);
            Character charAtEnd=s.charAt(end);

            //If character pointed by start or end is not a alphanumeric value then skip it
            if(!Character.isLetterOrDigit(charAtStart)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(charAtEnd)){
                end--;
                continue;
            }

            //If character pointed by start and end is alphanumeric value,convert them to lowercase and check if they are same 
            //if same move to next characters otherwise return false
            if(Character.toLowerCase(charAtStart)!=Character.toLowerCase(charAtEnd))
                return false;
            start++;
            end--;
        }
        
        //returning true after comparing all characters as no mismatch found 
        return true;
    }
}