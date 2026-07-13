package Algortihms;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minPrice=prices[0];
        int maxProfit=Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            minPrice=Math.min(minPrice,prices[i]);
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }

        return maxProfit;
    }
}
