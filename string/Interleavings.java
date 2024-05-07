package string;
// https://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interleavings {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(5);
//        String str1 = "AB";
//        String str2 = "C";
//
//        solve(str1, str2, 0, 0, "");

        String s = "222.111.111.111";

        String[] arr = s.split(".");

        System.out.println(Arrays.toString(arr));

    }

    private static void solve(String str1, String str2, int i, int j, String s) {
        if(i == str1.length() && j == str2.length()){
            System.out.println(s);
            return;
        }

        if(i < str1.length()){
            solve(str1, str2, i+1,j, s+ str1.charAt(i));
        }

        if(j < str2.length()){
            solve(str1, str2, i,j+1, s + str2.charAt(j));
        }
    }
}
