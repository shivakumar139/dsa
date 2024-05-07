package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateSortedArray {
    public static void main(String[] args) {
        int[] a = {10,15,25};
        int[] b = {1,5,20,30};

        solve(new ArrayList<>(), a, b, 0, 0, true, -1);
    }

    private static void solve(List<Integer> list, int[] a, int[] b, int ai, int bi, boolean flag, int prevGreater){
        if((ai >= a.length || bi >= b.length) && flag){
            System.out.println(list);
            return;
        }



        if(flag && ai < a.length){
                if(a[ai] > prevGreater) {
                    list.add(a[ai]);
                    solve(list, a, b, ai + 1, bi, false, a[ai]);

                    list.remove(list.size() - 1);

                }
                solve(list, a, b, ai+1, bi, true, prevGreater);


        }



        if(!flag && bi < b.length){
                if(b[bi] > prevGreater){
                    list.add(b[bi]);
                    solve(list, a, b, ai, bi+1, true, b[bi]);

                    list.remove(list.size()-1);

                }
                solve(list, a, b, ai, bi+1, false, prevGreater);


        }




    }
}
