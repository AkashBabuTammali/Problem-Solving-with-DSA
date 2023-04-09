/*
 * 75. Sort Colors
 * Problem Link: https://leetcode.com/problems/sort-colors/
 * Algorithm: Dutch National Flag Algorithm or 3-Pointer Approach
 * Time Complexity: O(N)
 * Space Complexity: O(1)
*/
class Solution {
    public void sortColors(int[] nums) {
        /*
         *Creating three variables low, mid and high which represent red(0), white(1), blue(2).
         *Initially low and mid point to 0th index and high point to last index.
         */
        int low=0,mid=0,high=nums.length-1;
        //Running loop until mid<=high
        while(mid<=high){
            //if nums[mid]==0, swap elements at index low ,mid and incrementing low and mid.
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            //if nums[mid]==1, incrementing mid.
            }else if(nums[mid]==1){
                mid++;
            //if nums[mid]==2, swap elements at index mid, high and decrementing high.
            }else if(nums[mid]==2){
                swap(mid,high,nums);
                high--;
            }
        }
    }
    //This method is used to swap elements at index i and j in array 
    public void swap(int i,int j,int[]arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}