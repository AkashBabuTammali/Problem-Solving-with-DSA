/*
 * Count Inversions
 * Problem Link: https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * Algorithm: Enhanced Merge Sort
 * Time Complexity:O(NlogN)
 * Space Complexity:O(N)
*/
class Solution
{
    static long inversionCount(long arr[], long N)
    {
        //This Algorith will modify the input array so creating a copy of it 
        long[] arr_copy=Arrays.copyOfRange(arr,0,(int)N);
        //Creating a temporary array of size arr
        long[] temp=new long[(int)N];
        //this function will divide the array into two parts recursively until each part has only one element
        //return the inversions count of array
        return getInversions(0,(int)N-1,arr_copy,temp);
    }
    static long getInversions(int start,int end,long[] arr,long[] temp){
        //if subarray(start,end) has only one element, then there will be no inversions, returning 0.
        if(start>=end){
            return 0;
        }
        //calcuating mid of array to divide the array into two parts
        int mid = start+((end-start)/2);
        //storing the inversions of first part in count
        long inversions=getInversions(start,mid,arr,temp);
        //adding the inversions of second part to count
        inversions+=getInversions(mid+1,end,arr,temp);
        //Now, merging both parts to find the inversions
        inversions+=merge(start,mid,end,arr,temp);
        return inversions;
    }
    static long merge(int start,int mid,int end,long[] arr,long[] temp){
        //i will point to starting element of part one
        int i=start;
        //j will point to starting element of part two
        int j=mid+1;
        //k will point to starting element of temp array,which will store the elements of both parts in sorted format
        int k=start;
        //count will store inversions in both parts
        long invCount=0;
        //individually both parts are sorted ,Now we are merging them
        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
                //we know that when arr[i]>arr[j], where i<j it forms a inversion pair
                //since all elements after arr[i] in part one can forma inversion pair with arr[j]
                //No. of elements from i till the end of first part are mid-i+1
                //mid is the index of last element in part one, i is the index of starting element which forms inversion pair 
                invCount+=mid-i+1;
            }
        }
        //adding leftover elements in part1 to temp array
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        //adding leftover elements in part2 to temp array
        while(j<=end){
            temp[k++]=arr[j++];
        }
        //Copying all elements from temp to array
        for(i=start;i<=end;i++){
            arr[i]=temp[i];
        }
        //returning inversions
        return invCount;
    }
}