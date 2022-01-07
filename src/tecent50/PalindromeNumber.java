package tecent50;

public class PalindromeNumber {
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = x % 10 + revertedNumber * 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}