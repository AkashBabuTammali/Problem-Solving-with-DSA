/*
 * 50. Pow(x, n)
 * Problem Link: https://leetcode.com/problems/powx-n/
 * Algorithm: Binary Exponentiation
 * Time Complexity:O(Log(N))
 * Space Complexity:O(1)
*/
class Solution {
    public double myPow(double x, int n) {
        //Creating a long variable pow which store n
        long power=n;
        //If n is negative, convert it to positive and store it in pow
        //Reason why we are storing power in long is, if n is Integer.MIN_VALUE,
        //It will overflow after converting to postive, 
        //To prevent it from overloading, we will store power in long variable
        if(n<0)
            power=(long)n*-1;
        
        double ans=1.0;


        //Running a while loop till power is not equal to 0
        while(power!=0){
            //If power is odd, decrement power by 1
            if(power%2!=0){
                ans*=x;
                power=power-1;
            //If power is evn, decrement power by half
            }else{
                power/=2;
                x=x*x;
            }
        }
        //If power is negative, return 1/ans
        if(n<0)
            ans=(double)1.0/ans;
        return ans;
    }
}