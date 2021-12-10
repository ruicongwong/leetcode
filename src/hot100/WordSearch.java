package hot100;

public class WordSearch {

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = new char[][]{{'A','B','C', 'E'},
                {'S','F','C', 'S'},
                {'A','D','E', 'E'},};
        boolean abcced = solution79.exist(board, "ABCCED");
        System.out.println(abcced);
    }
}

class Solution79 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = dfs(board, word, i, j, visited, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited, int k) {
        if (board[row][col] != word.charAt(k)) {
            return false;
        } else if (k == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = {{0, 1}, {0 ,-1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                if (!visited[newRow][newCol]) {
                    boolean flag = dfs(board, word, newRow, newCol, visited, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[row][col] = false;
        return result;
    }
}