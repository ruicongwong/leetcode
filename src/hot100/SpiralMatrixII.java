package hot100;

public class SpiralMatrixII {
    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        System.out.println(solution59.generateMatrix(3));
    }
}

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int index = 0;
        for (int i = 1; i <= n * n; i++) {
            matrix[row][col] = i;
            int nextr = row + directions[index][0];
            int nextc = col + directions[index][1];
            if (nextr >= n || nextr < 0 || nextc >= n || nextc < 0 || matrix[nextr][nextc] != 0) {
                index = (index + 1) % 4;
            }
            row = row + directions[index][0];;
            col = col + directions[index][1];
        }
        return matrix;
    }
}