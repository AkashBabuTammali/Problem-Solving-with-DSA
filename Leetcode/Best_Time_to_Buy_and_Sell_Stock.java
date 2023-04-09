/*
 * 121. Best Time To Buy and Sell stock
 * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Algorithm: -
 * Time Complexity: O(N)
 * Space Complexity: O(1)
*/
class Solution {
    public int maxProfit(int[] prices) {
        //Creating a variable, which will store index when stock bought
        int buy=0;
        //Creating a variable maxProfit to store maxProfit, Initially storing 0.
        int maxProfit=0;
        //Looping through prices array starting from first index
        for(int i=1;i<prices.length;i++){
            //If stock value at current index is less than existing stock value, update buy
            if(prices[i]<prices[buy]){
                buy=i;
            //check if profit obtained by selling stock at current index is more than exiting profit, then update maxProfit
            }else if(maxProfit<prices[i]-prices[buy]){
                maxProfit=prices[i]-prices[buy];
            }
        }
        //return maxProfit
        return maxProfit;
    }
}