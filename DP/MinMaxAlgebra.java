package DP;

import java.util.Arrays;

public class MinMaxAlgebra {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int n = 2, m = 2;
        int[] arr = {1,2,3,4};

        minMaxAlgebra(arr, n, m);
        System.out.println(min + " "  + max);
    }

    private static void minMaxAlgebra(int[] arr, int n, int m) {

        int sum = Arrays.stream(arr).sum();
        solve(arr, n-1, sum, arr.length-1, 0);
    }

    private static void solve(int[] arr, int n, int sum, int i, int sum2) {

        if(n < 0){
            System.out.println("sum2: " + sum2);
            min = Math.min(min, sum2 * Math.abs(sum2-sum));
            max = Math.max(max, sum2 * Math.abs(sum2-sum));
            return;
        }
        if(i < 0) return;

        System.out.println("i: " + i + " n: " + n);

        // take
        solve(arr, n-1, sum, i-1, sum2+arr[i]);
        solve(arr, n, sum, i-1, sum2);
    }
}
