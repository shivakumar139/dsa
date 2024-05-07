package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class PowerSet {
    public static void main(String[] args) {
        rec("abc", 0, "");
    }


    private static void rec(String str, int i, String s){
        if(i >= str.length()){
            System.out.println(s);
            return;
        }


        rec(str, i+1,s);
        rec(str, i+1,s+str.charAt(i));

    }

    private static void solve(String str){

        ArrayList<String> l = new ArrayList<>();

        for(int i=0; i<str.length(); i++){
            ArrayList<String> cpy = new ArrayList<>(l);

            for(int j=0; j< cpy.size(); j++){
                l.add(cpy.get(j) + str.charAt(i));
            }
            l.add(str.charAt(i)+"");
        }

        Collections.sort(l);

        System.out.println(l);
    }
}
