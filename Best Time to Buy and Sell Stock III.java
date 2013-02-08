public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int len = prices.length, index = 0, dayPro, profit = 0;
        if (len == 0) {
            return 0;
        }
        int[] pro = new int[len];
        
        for (int i = 0; i < len; i++) {
            pro[i] = 0;
        }
        
        pro[0] = -1;//sentinel
        for (int i = 0; i < len - 1; i++) {
            dayPro = prices[i + 1] - prices[i];
            if (dayPro == 0) {
                continue;
            }
            if((dayPro ^ pro[index]) < 0) {  //diff sign
                index++;
                pro[index] = dayPro;
            } else {                        //same sign
                pro[index] += dayPro;
            }
        }
        
        if (pro[index] < 0) {
            index--;
        }
        
        for (int i = 1; i <= index; i++) {
            int tmp = subMax(pro, 1, i) + subMax(pro, i + 1, index);
            profit = tmp > profit ? tmp : profit;
        }
        return profit;
        
    }
    public int subMax(int[] prices, int start, int end) {
        if (start > end) {
            return 0;
        }
        int max = 0, sum = 0; 
        for (int i = start; i <= end; i++) {
            if (sum + prices[i] < 0) {
                sum = 0;
                continue;
            }
            sum += prices[i];
            max = sum > max ? sum : max;
        }
        return max;
    }
}