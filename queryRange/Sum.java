package queryRange;

public class Sum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(rangeSum(arr, 0,2));
        System.out.println(rangeSum(arr, 1,2));
    }

    private static int rangeSum(int[] arr, int l, int r) {

        int n = arr.length;
        int sqrt = (int) Math.sqrt(n);

        int blockId = -1;

        int[] blocks = new int[sqrt+2];
        // calculate blocks

        for(int i=0; i<n; i++){
            if(i%sqrt == 0){
                blockId++;
            }

            blocks[blockId] += arr[i];
        }
        int ans = 0;

        // left part
        while(l%sqrt !=0 && l<r && l!=0){
            ans+= arr[l];
            l++;
        }

        // middle part
        while(l+sqrt <= r){
            ans+= blocks[l/sqrt];
            l += sqrt;
        }


        // right
        while(l <= r){
            ans+= arr[l];
            l++;
        }

        return ans;
    }
}
