/*
 * 31. Next Permutation
 * Problem Link: https://leetcode.com/problems/next-permutation/
 * Algorithm: -
 * Time Complexity:O(3N)
 * Space Complexity:O(1)
*/
class Solution {
    public void nextPermutation(int[] nums) {
        int pivot=-1;
        int pivotSuccessor=-1;
        int startReverseIndex=0;
        /*Finding the pivot, which holds the index from where the difference starts in current and next permutation
         *                          ---
         *Ex:Current permutaion:: 13|4|52
         *                          ---
         *   Next permutation  :: 13524
         *
         *
         */
        for(int index=nums.length-2;index>=0;index--){
            if(nums[index]<nums[index+1]){
                pivot=index;
                break;
            }
        }
        if(pivot!=-1){
            //Traversing from end of the array and finding the index of rightmost element whose value is greater than value at pivot
            for(int index=nums.length-1;index>=0;index--){
                if(nums[index]>nums[pivot]){
                    pivotSuccessor=index;
                    break;
                }
            }
            //Swapping element at pivot and pivotSuccessor
            swap(pivot,pivotSuccessor,nums);
            //We need to reverse all elements after pivot
            startReverseIndex=pivot+1;
        }
        //If pivot is -1, reverse entire array
        reverse(startReverseIndex,nums);
        return;
    }
    //This method swaps values at index i and j in array nums
    public void swap(int i,int j,int[] nums){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    //This method reverse everything starting from index i in array nums
    public void reverse(int i,int[] nums){
        int start=i,end=nums.length-1;
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}