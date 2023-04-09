/*
 * 242. Valid Anagram
 * Problem Link: https://leetcode.com/problems/valid-anagram
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        //Since characters in string are just limited to lowercase, creating an array of size 26
        int[]arr=new int[26];

        //If both string are of different length then return false
        if(s.length()!=t.length())
            return false;

        //Looping both strings In single for loop
        for(int index=0;index<s.length();index++){
            //converting character value in range (0-25)
            int charInSAsciiValue=s.charAt(index)-'a';
            int charInTAsciiValue=t.charAt(index)-'a';

            //Incrementing the value of string s character
            arr[charInSAsciiValue]++;

            //Decrementing the value of string t character
            arr[charInTAsciiValue]--;
        }

        //If String t is formed by rearranging characters in string s, all elements in array will be zero
        for(int index=0;index<26;index++){
            if(arr[index]!=0)
                return false;
        }
        return true;
    }
}