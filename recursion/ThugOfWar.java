package recursion;
//https://www.geeksforgeeks.org/tug-of-war/
public class ThugOfWar {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};

        System.out.println(minDiff(arr));
    }

    private static int minDiff(int[] arr) {
        int sum = 0;
        for(int data: arr) sum+= data;
        return solve(arr, sum, 0, 0, arr.length/2);
    }

    private static int solve(int[] arr, int sum, int half, int index, int remain) {

        if(remain == 0) {
            int lefthalf = sum-half;
            return Math.abs(lefthalf - half);
        }

        if(index >= arr.length) return Integer.MAX_VALUE;

        int takr = solve(arr, sum, half+arr[index], index+1, remain-1);
        int notTake = solve(arr, sum, half, index+1, remain);

        return Math.min(takr, notTake);
    }
}
