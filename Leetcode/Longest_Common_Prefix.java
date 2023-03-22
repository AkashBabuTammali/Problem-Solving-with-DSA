/*
14. Longest Common Prefix
Problem Link: https://leetcode.com/problems/longest-common-prefix/description/
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //Looping over characters of first string
        for(int i=0;i<strs[0].length();i++){
            char c=strs[0].charAt(i);
            //Loopig over ith character in remaining strings
            for(int j=1;j<strs.length;j++){
                //if iterating any string is completed or charcternot matches in any string, return substring till ith index in first string of array
                if(i==strs[j].length() || c!=strs[j].charAt(i))
                    return strs[0].substring(0,i);
            }
        }
        //Control will reach here if first string is the longest common prefix
        return strs[0];
    }
}