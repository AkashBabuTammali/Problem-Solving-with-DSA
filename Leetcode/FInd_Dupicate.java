/*
 * 56. Merge Sorted Array
 * Problem Link: https://leetcode.com/problems/merge-sorted-array/
 * Algorithm: Slow and Fast Pointers
 * Time Complexity:O(N)
 * Space Complexity:O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        //Creating two pointers slow pointer(sp) and fast pointer(fp)
        //sp moves one step at a time and fp move two step at a time
        //Initially sp and fp points to 0th index
        //here pointers use value at index which they point to move to index
        int sp=0,fp=0;
        sp=nums[sp];
        fp=nums[nums[fp]];

        //Move both pointers till they collide
        while(sp!=fp){
            sp=nums[sp];
            fp=nums[nums[fp]];
        }

        //Once they collide, make fp to point to 0th index
        fp=0;

        //Now move both pointers one step at a time till they collide
        while(sp!=fp){
            sp=nums[sp];
            fp=nums[fp];
        }

        //return the index they collide
        return sp;
    }
}
/*
    // Algorithm: Negative Indexing
    // Time Complexity:O(N)
    // Space Complexity:O(1)

    class Solution {
        public int findDuplicate(int[] nums) {
            //Looping entire nums array
            for(int i=0;i<nums.length;i++){
                //Storing value at index i in a variable after converting it to positive if value is negative
                int value=convertToPositive(nums[i]);
                //Now using value as index, Checking if element at nums[value] is negative, if yes then return value
                if(nums[value]<0)
                    return value;
                //converting value at nums[value] to negative
                nums[value]=nums[value]*-1;
            }
            return -1;
        }

        //This method will convert value to positive 
        private int convertToPositive(int value){
            return value<0?value*-1:value;
        }
    }
    //NOTE:This method is not preferred even though its time complexity and space complexity is as same as 
    //     slow and fast pointers. In this method, we are chnaging the input array which is not acceptable
*/