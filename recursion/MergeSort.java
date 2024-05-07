package recursion;
import java.util.*;
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {14, 9, 15, 12, 6, 8, 13, 0};

        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int start, int end){
        if(start >= end) return;
        int mid = start + (end - start) /2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end){
        int[] mix = new int[end-start+1];
        int i=start, j = mid+1;
        int k=0;
        while(i <= mid && j <= end){
            if(arr[i] < arr[j]){
                mix[k++] = arr[i++];
            }else{
                mix[k++] = arr[j++];
            }
        }
        while(i <= mid){
            mix[k++] = arr[i++];
        }
        while(j <= end){
            mix[k++] = arr[j++];
        }
        k=0;
        while(k < mix.length){
            arr[k+start] = mix[k++];
        }
    }
}
