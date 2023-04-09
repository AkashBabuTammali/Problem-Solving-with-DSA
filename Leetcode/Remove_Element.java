/*
 * 27. Remove Element
 * Problem Link: https://leetcode.com/problems/remove-element/
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        //Creating two pointers Initially,
        //pointerA will point to distinct elements while pointerB is used to traverse the array.
        int pointerA=0,pointerB=0;

        //Creating a variable to store distinct Elements
        int distinctElements=0;

        //Running the loop till reaches te array end
        while(pointerB<nums.length){
            //If pointerB points to element which need to be removed then move to next index
            if(nums[pointerB]==val){
                pointerB++;
            }else{
                //Replace the value pointed by pointerA with value pointed by pointerB
                //By doing so all element to be removed will be thrown to end of array.
                nums[pointerA]=nums[pointerB];
                pointerA++;
                pointerB++;
                distinctElements++;
            }
        }
        return distinctElements;
    }
}