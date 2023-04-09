/*
 * Find Missing And Repeating
 * Problem Link: https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
 * Algorithm: Using XOR Operator
 * Time Complexity:O(5N)
 * Space Complexity:O(1)
*/
class Solve {
    int[] findTwoElement(int arr[], int n) {
        //Creating two variables repeat and missing which holds -1 initially
        int repeat=-1,missing=-1;
        //Creating a variables xor which hold s the result of xor operation
        int xor=0;
        //Looping across all the elements of array 
        //performing xor on all elements and storing in xor
        for(int i=0;i<n;i++){
            xor^=arr[i];
        }
        //Looping across all the elements in range(1-n)
        //performing xor on all elements and storing in xor
        for(int i=1;i<=n;i++){
            xor^=i;
        }
        //setting all bits to zero except the rightmost set bit in xor 
        int bitMask=xor&(~xor+1);
        //Creating two buckets
        //if the result of operation (arr[i]&bitMask) is 1 then we will perform xor with bucket1 else bucket2
        int bucket1=0,bucket2=0;
        for(int i=0;i<n;i++){
            if((arr[i]&bitMask)!=0)
                bucket1^=arr[i];
            else
                bucket2^=arr[i];
        }
        for(int i=1;i<=n;i++){
            if((i&bitMask)!=0)
                bucket1^=i;
            else
                bucket2^=i;
        }
        //Now bucket1 and bucket2 conatains repeat and mssing numbers, 
        //But we dont know which bucket has missing and which has repeated number
        //So again looping across array and checking
        for(int i=0;i<n;i++){
            if(arr[i]==bucket1){
                repeat=bucket1;
                missing=bucket2;
                return new int[]{repeat,missing};
            }
                
        }
        repeat=bucket2;
        missing=bucket1;
        return new int[]{repeat,missing};
    }
}