package recursion;

import java.util.ArrayList;

public class SubSetSum {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int sum = 5;

        solve(arr, sum, new ArrayList<>(), arr.length-1);
        System.out.println(helper(arr, arr.length-1, sum));
    }

    private static void solve(int[] arr, int sum, ArrayList<Integer> list, int index) {
        if(sum == 0){
            System.out.println(list);
            return;
        }
        if(sum < 0 || index < 0) return;

        list.add(arr[index]);
        solve(arr, sum-arr[index], list, index-1);

        list.remove(list.size()-1);

        solve(arr, sum, list, index-1);
    }

    private static boolean helper(int[] arr,  int ind, int k){
        System.out.println("(" + ind + "," + k + ")");

        if(k == 0) return true;
        if(ind < 0 || k < 0) return false;

        boolean take = helper(arr, ind-1, k-arr[ind]);
        boolean notTake =  helper(arr, ind-1, k);

        return (take || notTake);
    }
}
