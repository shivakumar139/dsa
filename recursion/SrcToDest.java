package recursion;

public class SrcToDest {
    public static void main(String[] args) {
        System.out.println(solve(20,10, 6, 12));
    }

    private static boolean solve(int x, int y, int x2, int y2) {
        if(x > x2 || y > y2) return false;

        if(x == x2 && y == y2) return true;

        return solve(x+y, y, x2, y2) || solve(x, x+y, x2, y2);
    }
}
