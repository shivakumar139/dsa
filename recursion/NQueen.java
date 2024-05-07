package recursion;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        solve(0, board);
    }

    private static void solve(int row, boolean[][] board) {
        if(row == board.length){
            printBoard(board);
            System.out.println("************************");
            return;
        }

        for(int col=0; col<board.length; col++){
            if(isSafe(row, col, board)){
                board[row][col] = true;
                solve(row+1, board);
                board[row][col] = false;
            }
        }


    }

    private static boolean isSafe(int row, int col, boolean[][] board) {

        // row
        for(int i=0; i<row; i++){
            if(board[i][col]) return false;
        }

        // left-right diagonal
        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(board[r--][c--]) return false;
        }

        // right-left diagonal
        r = row;
        c = col;
        while(r >= 0 && c < board.length){
            if(board[r--][c++]) return false;
        }

        return true;
    }

    private static void printBoard(boolean[][] board) {
        for(boolean[] row: board){
            for(boolean col: row){
                if(col){
                    System.out.print("Q ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

}
