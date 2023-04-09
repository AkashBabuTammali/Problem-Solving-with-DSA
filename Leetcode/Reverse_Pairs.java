/*
 * 493. Reverse Pairs
 * Problem Link: https://leetcode.com/problems/reverse-pairs/
 * Algorithm: Enhanced Merge sort
 * Time Complexity:O(NlogN)
 * Space Complexity:O(N)
*/
class Solution {
    public int reversePairs(int[] nums) {
        //Dividing array until we get one element in each partition
        return divide(0,nums.length-1,nums);
    }
    public int divide(int start,int end,int[]nums){
        //If partition contain one element, return zero because we cannot from a reverse pair with one element
        if(start>=end)
            return 0;
        //Finding mid from start and end
        int mid=start+((end-start)/2);
        //recursively dividing partitions (start,mid) and (mid+1,end)
        int reversePairs=divide(start,mid,nums);
        reversePairs+=divide(mid+1,end,nums);
        //Again merging above two partitions to sort them in ascending order, simulatneously counting reverse pairs
        reversePairs+=merge(start,mid,end,nums);
        //returning reversePairs
        return reversePairs;
    }
    public int merge(int start,int mid,int end,int[]nums){
        int starti=start;
        int startj=mid+1;
        int reversePairs=0;
        //Calculating reverse pairs
        while(starti<=mid && startj<=end){
            if(nums[starti]>2*(long)nums[startj]){
                reversePairs+=mid-starti+1;
                startj++;
            }
            else{
                starti++;
            }
        }

        starti=start;
        startj=mid+1;
        int k=0;
        int[]temp=new int[end-start+1];

        //Sorting the partition(start,end)
        while(starti<=mid && startj<=end){
            if(nums[starti]<=nums[startj]){
                temp[k++]=nums[starti++];
            }
            else{
                temp[k++]=nums[startj++];
            }
        }
        while(starti<=mid)
            temp[k++]=nums[starti++];
        while(startj<=end)
            temp[k++]=nums[startj++];
        k=0;
        for(;start<=end;start++){
            nums[start]=temp[k++];
        }
        return reversePairs;
    }
}