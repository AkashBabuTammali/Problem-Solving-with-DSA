/*
 * 9. Palindrome Number
 * Problem Link: https://leetcode.com/problems/palindrome-number/description/
*/
class Solution {
    public boolean isPalindrome(int x) {
        //If x contain negative number or number which is divisible by 10 but'nt 0 then return false
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        //Computing second half of number
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        //checking whether first half and second half are same or not
        return (x==rev || x==rev/10);
    }
}