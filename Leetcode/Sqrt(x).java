/*
 * 69. Sqrt(x)
 * Problem Link: https://leetcode.com/problems/sqrtx/
 * Algorithm: -
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
*/
class Solution {
    public int mySqrt(int x) {
        //If integer is 0, its square root is 0
        if(x==0) return 0;
        //Creating two pointers, namely low and high, low points to 1 and high points to x
        int low = 1,high = x,ans =0;
        //running while loop untill low<=high
        while(low<=high){
            //Finding the mid point of low and high
            //we can find mid point using (low+high)/2, but it may result in overflow, thats why using a different approach
            int mid =low + (high-low)/2;
            //checking if mid is the square roort of x
            if(x/mid==mid)  return mid;
            //checking if x is less than mid^2
            else if(x/mid<mid)   
                high=mid-1;
            //checking if x is greater than mid^2
            //if squareroot lies between two numbers, so storing mid in ans when mid^2 is less than x
            else {
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}