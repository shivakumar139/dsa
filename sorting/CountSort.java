package sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 12, 6, 8, 13, 0};

        // get max element
        int max = 0;
        for(int data: arr) {
            max = Math.max(max, data);
        }

        // count frequency
        int[] count = new int[max+1];
        for(int data: arr) {
            count[data]++;
        }

        // calculate sum
        for(int i=1; i< count.length; i++){
            count[i] += count[i-1];
        }

        int[] ans = new int[arr.length];
        for(int i=arr.length-1; i>=0; i--){
            ans[count[arr[i]]-1] = arr[i];
        }

        System.out.println(Arrays.toString(ans));


    }
}
