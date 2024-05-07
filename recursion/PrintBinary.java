package recursion;

public class PrintBinary {
    public static void main(String[] args) {
        solve(5, "", "", 0);
    }

    private static void solve(int n, String left, String right, int di) {

        if (n == 0) {
            if (di == 0) {
                System.out.println(left + right);
            }
            return;
        }

            if (n == 1) {
                if (di == 0) {
                    System.out.println(left + "0" + right);
                    System.out.println(left + "1" + right);
                }
                return;
            }


            solve(n - 2, left + "0", right + "0", di);
            solve(n - 2, left + "1", right + "1", di);
            solve(n - 2, left + "0", right + "1", di + 1);
            solve(n - 2, left + "1", right + "0", di - 1);
        }
}
