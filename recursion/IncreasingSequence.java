package recursion;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSequence {
    public static void main(String[] args) {

        solve(new ArrayList<>(), 1, 5, 3);
    }

    private static void solve(List<Integer> list, int start, int end, int k){
        if(list.size() == k){
            System.out.println(list);
            return;
        }
        if(start > end){
            return;
        }


        list.add(start);
        solve(list, start+1, end, k);

        list.remove(list.size()-1);
        solve(list, start+1, end, k);


    }
}
