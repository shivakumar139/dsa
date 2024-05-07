import java.util.*;

public class Intuite {
    public static void main(String[] args) {



        int days = 2;
        int[] arr = {0,1,0,0,0,0,1,0,0,0};

        while(days-- > 0) {
            int[] cpy = Arrays.copyOf(arr,arr.length);
            for (int i = 1; i <= 8; i++) {
                cpy[i] = arr[i-1] == arr[i+1]?0:1;
            }
            arr = cpy;
        }

        for (int i = 1; i <= 8; i++) {
            System.out.print(arr[i] + " ");
        }



    }


}
