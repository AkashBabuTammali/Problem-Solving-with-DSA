/*
 * 229. Majority Element II
 * Problem Link: https://leetcode.com/problems/majority-element-ii/
 * Algorithm: Extended Boyer Moore Voting Algorithm
 * Time Complexity:O(N)
 * Space Complexity:O(1)
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Creating a List which will store numbers which occurs more than N/3 times
        List<Integer> res = new ArrayList<Integer>();

        //At max there can be only two numbers which occurs more than N/3 times
        int num1 = -1, num2 = -1, count1 = 0, count2 = 0, n = nums.length;

        //Looping the array 
        for(int number: nums){
            //Checking if num1 equals to number,If Yes incrementing its count
            if(number == num1)   count1++;
            //Checking if num2 equals to number,If Yes incrementing its count
            else if(number == num2)  count2++;
            //if count1 equals to 0, assigning number to num1, count=1
            else if(count1 == 0){
                num1 = number;
                count1 = 1;
            }
            //if count2 equals to 0, assigning number to num2, count=1
            else if(count2 == 0){
                num2 = number;
                count2 = 1;
            }
            //If number not equal to num1 and num2 decrement count1 and count2
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0; count2 = 0;
        //Loop over the array and now find the count of num1 and num2
        for(int number: nums){
            if(number == num1)   count1++;
            if(number == num2)   count2++;
        }

        //Check if num1 and num2 occurs more than N/3, add to list which satisfies the condition
        if(count1 > n/3)    res.add(num1);
        
        if(num1 != num2)
        if(count2 > n/3)    res.add(num2);

        //returning the list 
        return res;
    }
}