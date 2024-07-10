package DP;

import java.util.Arrays;

public class EqualSubarray {
    public static void main(String[] args) {
        int[] arr = {5, 5, 1, 11};
        int sum = Arrays.stream(arr).sum();
        int[][] dp = new int[sum/2+1][arr.length];

        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));



        System.out.println(solve(arr, sum/2, arr.length-1));
    }

    private static boolean solve(int[] arr, int sum, int i) {
        if(sum == 0) return true;
        if(i < 0) return false;


        // take
        boolean take = false;
        if(arr[i] <= sum){
            take = solve(arr, sum-arr[i], i-1);
        }

        // notTake
        boolean notTake = solve(arr, sum, i-1);

        return take || notTake;
    }
}
