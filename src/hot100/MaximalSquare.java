package hot100;

public class MaximalSquare {
}

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        int[][] dp = new int[col][row];
        int side = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == '1'){
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    }
                    side = Math.max(side, dp[i][j]);
                }
            }
        }
        return side * side;
    }
}