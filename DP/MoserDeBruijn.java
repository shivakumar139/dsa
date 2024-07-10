package DP;

public class MoserDeBruijn {
    public static void main(String[] args) {

        for(int i=0; i<10; i++)
            System.out.println(moserDeBruijn(i));
    }

    private static int moserDeBruijn(int n){
        if(n <= 1) return n;

        if(n%2 == 0){
            return 4 * moserDeBruijn(n/2) ;
        }

        return 4 * moserDeBruijn(n/2)+1;
    }
}
