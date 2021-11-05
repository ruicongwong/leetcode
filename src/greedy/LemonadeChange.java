package greedy;


public class LemonadeChange {
}


class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        int cash_5 = 0;
        int cash_10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                cash_5 ++;
            } else if(bill == 10) {
                cash_10 ++;
                cash_5 --;
            } else {
                if(cash_10 > 0){
                    cash_10 --;
                    cash_5 --;
                } else {
                    cash_5 -= 3;
                }
            }
            if(cash_5 < 0 || cash_10 < 0) return false;
        }
        return true;
    }
}
