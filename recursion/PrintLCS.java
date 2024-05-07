package recursion;

import java.util.Arrays;

public class PrintLCS {
    public static void main(String[] args) {




        String s1 = "abca";
        String s2 = "abac";

        System.out.println(tabulaion(s1, s2));

    }
    private static  int tabulaion(String a, String b){
        int n = a.length(), m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=m; i++){
            dp[0][i] = 0;
        }
        for(int i=0; i<=n; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(Arrays.deepToString(dp));

        return dp[n][m];


    }
    private static int solve(String a, String b, int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1) return dp[i][j];

        if(a.charAt(i) == b.charAt(j)){
            return solve(a, b, i-1, j-1, dp) + 1;
        }

        return dp[i][j] = Math.max(solve(a, b, i-1, j, dp), solve(a, b, i, j-1, dp));


    }

}
