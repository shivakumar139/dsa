package DP;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class LinearEquation {
    public static void main(String[] args) {
//        int[] coeff = {1,2};
//        int rhs = 5;
//        System.out.println(linearEquation(coeff,rhs));

        TreeSet<Integer> pq = new TreeSet<>();
        pq.add(4);
        pq.add(1);
        pq.add(6);

        while (!pq.isEmpty()){
            System.out.println(pq.pollLast());
        }
    }

    private static int linearEquation(int[] coeff, int rhs){
        int[][] dp = new int[rhs+1][coeff.length];

        for(int[] row: dp) Arrays.fill(row, -1);

        return memoization(coeff, rhs, 0, dp);
    }

    private static int recursion(int[] coeff, int rhs, int index){
        if(rhs == 0) return 1;
        if(index >= coeff.length) return 0;

        int ans = 0;

        for(int i=0; i<=rhs; i++){
            if(coeff[index]*i <= rhs){
                ans += recursion(coeff, rhs-(coeff[index]*i), index+1);
            }
        }

        return ans;
    }

    private static int memoization(int[] coeff, int rhs, int index, int[][] dp){
        if(rhs == 0) return 1;

        if(index >= coeff.length) return 0;

        if(dp[rhs][index] != -1) return dp[rhs][index];
        int ans = 0;

        for(int i=0; i<=rhs; i++){
            if(coeff[index]*i <= rhs){
                ans += recursion(coeff, rhs-(coeff[index]*i), index+1);
            }
        }

        return dp[rhs][index] = ans;
    }
}
