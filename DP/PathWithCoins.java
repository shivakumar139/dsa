package DP;

public class PathWithCoins {
    public static void main(String[] args) {
        int k = 12;
        int[][] mat = { {1, 2, 3},
            {4, 6, 5},
            {3, 2, 1}
        };
        int r = 3, c = 3;

        System.out.println(solve(mat, r-1, c-1, k));
    }

    private static int solve(int[][] mat, int row, int col, int k) {

        if(row < 0 || col < 0 || k < 0) return 0;

        if(row == 0 && col == 0 && k == mat[row][col]) return 1;

        return solve(mat, row-1, col, k-mat[row][col]) + solve(mat, row, col-1, k-mat[row][col]);
    }
}
