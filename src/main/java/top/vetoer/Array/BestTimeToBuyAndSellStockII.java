package top.vetoer.Array;


/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

 Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 Example 1:

 Input: [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 Example 2:

 Input: [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 engaging multiple transactions at the same time. You must sell before buying again.
 Example 3:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.

 */

/**
 * no buy no sell
 * buy no sell
 * no buy sell
 */

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        boolean buy=false;
        int m_buy = 0;
        int sum = 0;
        for(int i = 0;i < prices.length-1;i++){
            // 当前价比明天价高, 如果已买入,则卖出,如果没买,就跳过
            if(prices[i]>prices[i+1]){
                if(buy){
                    buy = false;
                    sum += prices[i]-m_buy;
                    m_buy = 0;
                }
            }else if(prices[i]<=prices[i+1]){   // 当前价比明天低,如果没有买入,则买入,已买入则跳过
                if(!buy){
                    m_buy = prices[i];
                    buy = true;
                }
                if(i+1==prices.length-1){
                    if(buy){
                        sum += prices[i+1]-m_buy;
                        buy = false;
                    }
                }
            }
        }
        return sum;
    }
    public int tt(int[] prices){
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }
    public static void main(String[] args){
        BestTimeToBuyAndSellStockII btas = new BestTimeToBuyAndSellStockII();
//        int[] t = {7,1,5,3,6,4};
//        int[] t = {1,2,3,4,5};
        int[] t = {1,9,6,9,1,7,1,1,5,9,9,9};
//        System.out.println(btas.maxProfit(t));
        System.out.println(btas.tt(t));
    }
}
