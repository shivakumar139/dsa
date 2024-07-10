package DP;

import java.util.ArrayList;
import java.util.List;

public class TileStacking {
    public static void main(String[] args) {
        int n = 3, m = 3, k = 2;

        System.out.println(solve(n, m, k,1, new ArrayList<>()));
    }

    private static int solve(int n, int m, int k, int currentTile, List<Integer> list) {
        if(n == 0) {
            System.out.println(list);
            return 1;
        }

        if(currentTile > m || n < 0) return 0;

        int ans = 0;
        for(int i=currentTile; i<=m; i++){
            for(int j=1; j<=k; j++){
                for(int l=0; l<j; l++)  list.add(i);

                ans += solve(n-j,m,k, i+1, list);

                for(int l=0; l<j; l++)  list.remove(list.size()-1);
            }

        }


        return ans;
    }

}
