/*
 * 53. Maximum Subarray
 * Problem Link: https://leetcode.com/problems/maximum-subarray/
 * Algorithm: Kadanes Algorithm
 * Time Complexity:O(N)
 * Space Complexity:O(1)
*/
class Solution {
    public int maxSubArray(int[] nums) {
        //Creating a variable maxSum to store maximum subarray sum
        int maxSum=Integer.MIN_VALUE;
        //Creating a variable sum to store subarray sum
        int sum=0;
        //Looping through entire array
        for(int index=0;index<nums.length;index++){
            //Adding value at index i to sum
            sum+=nums[index];
            //checking if sum if greater than maxSum
            if(sum>maxSum){
                //Updating maxSum with sum
                maxSum=sum;
            }
            //whenever sum goes negative, carrying to further even more reduce the value
            //So, assigning zero it
            if(sum<0)
                sum=0;
        }
        //return whatever value present in maxSum
        return maxSum;
    }
}
/*Note:: The reason why checking sum whether it is less than 0 is perforing at the end 
 *       is "If array contains all negative numbers, the maximum sum should be smallest 
 *       number in that array, but if we place this if condition in the starting of every
 *       iteration, it will return 0 instead of smallest number in the array"
 */