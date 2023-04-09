/*
 * 205. Isomorphic Strings
 * Problem Link: https://leetcode.com/problems/isomorphic-strings/
 * Algorithm: -
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        //CReating two arrays to keep track of prevIndex of every character in string s and t
        int[] arr1=new int[129];
        int[] arr2=new int[129];

        //If both string are of different length, they are not Isomorphic
        if(s.length()!=t.length())
            return false;
        //Looping Through strings
        for(int index=0;index<s.length();index++){
            //Determining Ascii value of characters in string s amd t.
            int charInS=s.charAt(index);
            int charInT=t.charAt(index);

            //Checking whether their previous indexes are same, if not return false.
            if(arr1[charInS]!=arr2[charInT])
                return false;
            
            //Storing Index+1 as the value at index equal to ascii value of character
            //To differentiate the character at index zero and new character, we are storing index+1
            arr1[charInS]=index+1;
            arr2[charInT]=index+1;
        }
        return true;
    }
}