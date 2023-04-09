/*
 * 169. Majority Element
 * Problem Link: https://leetcode.com/problems/majority-element/
 * Algorithm: Boyer Moore Voting Algorithm
 * Time Complexity:O(N)
 * Space Complexity:O(1)
*/
class Solution {
    public int majorityElement(int[] nums) {
        //There will be only one number, which occurs more than N/2 times in an array
        //Element will store the number which occurs more than N/2 times
        //As we dont know that number, we are storing -1 Initially
        int element=-1,count=0;

        //Looping over the array
        for(int Number:nums){
            //Checking if the element is equal to Number, If YES, increment the count.
            if(Number==element)
                count++;
            //If count is zero that means its not the required one, assign element with Number and count=1
            else if(count==0){
                element=Number;
                count=1;
            //Decrement count until it reaches zero
            }else{
                count--;
            }                
        }
        //Finally return element which hold the number which occurs more than N/2 times
        return element;
    }
}