/*
 * 118. Pascals Triangle
 * Problem Link: https://leetcode.com/problems/pascals-triangle/
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        //Creating List of Lists to store pascal Triangle
        List<List<Integer>>pascalTrainagle=new ArrayList<>();
        //Creating a List to store previous row of pascal triangle
        List<Integer>prevRow=null;
        //Looping rows of pascal triangle
        for(int row=1;row<=numRows;row++){
            //Creating a list to store elements of current row in pascal triangle
            List<Integer>currentRow=new ArrayList<>();
            //Looping through all the cells in current row of pascal triangle
            for(int cell=0;cell<row;cell++){
                //Storing 1 in first and last cells of a row
                if(cell==0 || cell==row-1)
                    currentRow.add(1);
                //Determining cell value in current row by adding cell at same index and index-1 in previous row
                else{
                    int nodeValue=prevRow.get(cell-1)+prevRow.get(cell);
                    currentRow.add(nodeValue);
                }
            }
            //adding current row to pascal triangle
            pascalTrainagle.add(currentRow);
            //Assigning current row to previous row
            prevRow=currentRow;
        }
        //returning pascal trainagle
        return pascalTrainagle;
    }
}