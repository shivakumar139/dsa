package recursion;

public class Steps {
    public static void main(String[] args) {
        System.out.println(solve(0, 0, 4));
    }

    private static int solve(int src, int steps, int dest) {
        if(Math.abs(src) > dest){
            return Integer.MAX_VALUE;
        }

        if(src == dest) return steps;

        return Math.min(solve(src+steps+1, steps+1, dest), solve(src-steps-1, steps+1, dest));
    }

}
