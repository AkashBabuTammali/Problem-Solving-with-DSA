/*
 * 56. Merge Sorted Array
 * Problem Link: https://leetcode.com/problems/merge-sorted-array/
 * Algorithm: -
 * Time Complexity:O(N^M)
 * Space Complexity:O(1)
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Coping all the nums2 array elements at the end of nums1.
        for(int index=0;index<n;index++){
            nums1[index+m]=nums2[index];
        }
        //If any one of the array is empty return
        if(m==0 || n==0)
            return;
        //Creating a pointer which points to starting element of nums2 in nums1 array
        int pointerB=m;
        //Looping nums1 array
        for(int pointerA=0;pointerA<m;pointerA++){
            //If element pointed by pointerB is less than element pointed by pointerA, swap them and sort the nums2 part in nums1
            if(nums1[pointerB]<nums1[pointerA]){
                swap(pointerA,nums1,pointerB,nums1);
                sort(pointerB,nums1);
            }
        }
    }
    //This method swap elements at two different indexes in arr1 and arr2
    private void swap(int i,int[]arr1,int j,int[]arr2){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
    //This will sort array starting from index i
    private void sort(int i,int[] arr){
        int low=i,high=arr.length-1;
        while(low<high){
            if(arr[low]<=arr[low+1])
                return;
            swap(low,arr,low+1,arr);
            low++;
        }
    }
}