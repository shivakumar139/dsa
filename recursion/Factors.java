package recursion;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static void main(String[] args) {
        solve(2, 16, new ArrayList<>());
    }

    private static void solve(int start, int n, List<Integer> list) {
        if(n == 1){

            System.out.println(list);
            return;
        }

        for(int i=start; i<=n ;i++){
            if(n%i==0){
                list.add(i);
                solve(i,n/i, list);
                list.remove(list.size()-1);
            }
        }
    }
}
