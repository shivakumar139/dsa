package recursion;

import java.util.Arrays;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] board = {
                {0,1,1,1},
                {0,0,0,0},
                {1,0,0,1},
                {0,0,0,0}
        };
        int[][] memo = new int[board.length][board[0].length];
        for(int[] row: memo) Arrays.fill(row, -1);

        boolean[][] isVisited = new boolean[board.length][board[0].length];
        System.out.println(solve(board,0, 0, isVisited,  "", memo));

        for(int[] row: memo){
            System.out.println(Arrays.toString(row));
        }
    }

    private static int solve(int[][] board, int r, int c, boolean[][] isVisited, String path, int[][] memo){
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || isVisited[r][c] || board[r][c] == 1) return 0;
        if(r == board.length-1 && c == board[0].length-1) {
            memo[r][c] = 1;
            System.out.println(path);
            return 1;
        }
//        if(memo[r][c] != -1) return memo[r][c];

        int ans = 0;
        isVisited[r][c] = true;
        ans += solve(board, r-1, c, isVisited, path+"U", memo);
        ans += solve(board, r+1, c, isVisited, path+"D", memo);
        ans += solve(board, r, c-1, isVisited, path+"L", memo);
        ans += solve(board, r, c+1, isVisited, path+"R", memo);
        isVisited[r][c] = false;

        return memo[r][c] = ans;



    }
}
