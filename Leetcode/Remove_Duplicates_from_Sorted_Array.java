/*
 * 26. Remove Duplicates from Sorted Array
 * Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        //Creating two poiters which Initially points to second element in the array,
        //because thats the point, from where there is a chance of duplicates
        int pointerA=1,pointerB=1;

        //storing no of distinct elements in variable distinctElements,
        //since we are excluding element at index 1, while looping. Initially storing 1 in distinctElements.
        int distinctElements=1;
        while(pointerB<nums.length){

            //If element pointed by pointerB and its previous elemenets are same just move move next index
            if(nums[pointerB-1]==nums[pointerB]){
                pointerB++;
            }else{
                //If element pointed by pointerB and its previous elemenets are distinct, copy the value into index pointed in pointerA.
                nums[pointerA]=nums[pointerB];

                //Increment both pointers along with count of distinct elements
                pointerA++;
                pointerB++;
                distinctElements++;
            }
        }
        return distinctElements;
    }
}