/*
 * 67. Add Binary
 * Problem Link: https://leetcode.com/problems/add-binary/
 * Algorithm: -
*/
class Solution {
    public String addBinary(String a, String b) {
        /*Creating object of StringBuilder class which will imitate String class Behavior, since String is immutable,
        using StringBuilder to efficiently store characters one by one at the end*/
        StringBuilder result=new StringBuilder();

        //Setting Cary to Zero Initially
        int carry=0;

        //Creating two pointers which will point to last characters of respective strings
        int i=a.length()-1,j=b.length()-1;

        //Running loop till iterating both string
        while(i>=0 || j>=0){
            //creating a variable to store the result of summation of two bits and initially assigning the carry from previous bits 
            int value=carry;
            
            //if string a have bits adding bit at ith index to value
            if(i>=0){
                value+=a.charAt(i)-'0';
                i--;
            }

            //if string b have bits adding bit at jth index to value
            if(j>=0){
                value+=b.charAt(j)-'0';
                j--;
            }

            /* prevCarry   a   b   result SUM   CARRY
             *         0 + 0 + 0 =   0     0      0
             *         0 + 1 + 0 =   1     1      0
             *         0 + 1 + 1 =   2     0      1
             *         1 + 1 + 1 =   3     1      1
             * 
             * If result is ODD, sum is 1 otherwise 0
             * If result is greater than 1 then carry is 1 otherwise 0
             */
            if(value%2!=0)
                result.append('1');
            else
                result.append('0');
            if(value>1)
                carry=1;
            else
                carry=0;
        }
        //Adding leftover carry to result string
        if(carry==1)
            result.append('1');
        /*since we are performing adding from ending of the strings, 
        result will be stored in reverse order thats why reversing the string before returning*/ 
        return result.reverse().toString();
    }
}