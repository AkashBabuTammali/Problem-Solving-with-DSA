/*
 * 119. Pascals Triangle II
 * Problem Link: https://leetcode.com/problems/pascals-triangle-ii/
 * Algorithm: -
 * Time Complexity:O(rowIndex)
 * Space Complexity:O(1)//Usually we will not consider result array or list while calculating space complexity
 */
class Solution {
    public List<Integer> getRow(int rowIndex) {
        /*
         *Using the concept of combinations, we can determine each cell value of a row
         *How to Find cell value at at Ith row and Jth column?
         *  
         *           i         i!
         * Cell(i,j)=  C =  ----------
         *              j   (i-j)! * j!
         *
         * Trick to find cell Value easily::
         *          perform i factorial but stop factorial once
                    elements in denominator equals to numerator
         *Cell(i,j)=--------------------------------------------
         *          perfrom j factorial
         *           3*2  -----
         *Cell(3,2)=----= | 3 |
         *           2*1  -----
         *
         * NOTE:: Assuming i and j values start from 0.
         */
        //Creating a list to store row of pascal triangle
        List<Integer>pascalRow=new ArrayList<>();
        //Since starting cell value of every row is 1, storing 1 in prevCell
        //There might be a chance of integer overflow, thats why prevCell and currCell declared as long
        long prevCell=1;
        pascalRow.add((int)prevCell);
        //Start looping cells from 2nd cell 
        for(int index=1;index<=rowIndex;index++){
            //Computing current cell value
            long currCell=(prevCell*(rowIndex-index+1))/index;
            //Adding current cell value to pascalROw
            pascalRow.add((int)currCell);
            prevCell=currCell;
        }
        return pascalRow;
    }
}