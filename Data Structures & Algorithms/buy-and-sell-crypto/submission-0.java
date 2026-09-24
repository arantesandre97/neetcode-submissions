// my constraint tells me that my prices array can have just one element, so this is a edge case
// where I won't buy anything because I can sell it before
// I should calculate for i which i + n will give me the best profit
// I can buy once, so if I find a best profit for an ith day, may I discard the past day?
// Actually if my last number is greater than my current I can discard it as a possible buy, right?
// From that number I will calculate the possible profit, if I find a better profit I store it
// Let do a quick dry run
/*
profit = 0
    l     r
[10,1,5,6,7,1]

10 < 1?
l = 1

1 < 5?
profit = 4

1 < 6?
profit = 5

1 < 7?
profit = 6

if prices[r] < prices[l]
    l++;
else if profit < (prices[r] - prices[l])
    profit = prices[r] - prices[l]

profit = 0
        l r
[10,8,7,5,2]

10 < 8?
l = 1

8 < 7?
l = 2

7 < 5?
l = 3

5 < 2
l = 4

profit = 0
*/

/*
so declare my l as 0
and loop my r from 1 to length - 1
if my current l value is bigger than my r value, I move my potential buy day to r position
otherwise I check if my current profit is smaller than my potential one, than store it if it is
*/

class Solution {
    public int maxProfit(int[] prices) {
        int l = 0;
        int profit = 0;
        for(int r = 1; r < prices.length; r++) {
            if(prices[l] > prices[r])
                l = r;
            else if(profit < (prices[r] - prices[l]))
                profit = prices[r] - prices[l];
        }

        return profit;
    }
}
