package recursion;

public class TOH {
    public static void main(String[] args) {
        solve(3, "A", "B", "C", "D");
    }

    private static void solve(int n, String src, String dest, String helper1, String helper2) {
        if(n==0) return;
        if(n==1){
            System.out.println("Moving " + n + " from " + src + " to " + dest);
            return;
        }

        solve(n-2, src, helper1, helper2, dest);
        System.out.println("Moving " + (n-1) + " from " + src + " to " + helper2);
        System.out.println("Moving " + n + " from " + src + " to " + dest);
        System.out.println("Moving " + (n-1) + " from " + helper2 + " to " + dest);

        solve(n-2, helper1, dest, helper2, src);
    }
}
