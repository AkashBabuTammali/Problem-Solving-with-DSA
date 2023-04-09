/*
 * 56. Merge Intervals
 * Problem Link: https://leetcode.com/problems/merge-intervals/
 * Algorithm: -
 * Time Complexity:O(N log N)+ O(N)
 * Space Complexity:O(1)
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        //Sorting input list based on element at 0th index in every sublist
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        //Creating two variables start and end which will store interval range
        //Initially assuming range is first interval
        int start=intervals[0][0],end=intervals[0][1];

        //Creating a list of Arrays which will store, merged intervals
        List<int[]>mergedList=new ArrayList<>();

        //Looping all intervals
        for(int[] interval:intervals){
            //checking if element at 0th index is less than or equals to end
            //If yes then that interval comes under the end
            if(interval[0]<=end)
                //updating end value
                end=Math.max(end,interval[1]);
            else{
                //if current interval range is not in between (start,end)
                //adding existing interval to list
                mergedList.add(new int[]{start,end});
                //updating start and end with new interval values
                start=interval[0];
                end=interval[1];
            }

        }
        //adding last interval values
        mergedList.add(new int[]{start,end});
        //converting list to array and resturing resultant 2d array
        return mergedList.toArray(new int[0][0]);
    }
}