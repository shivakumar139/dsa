package recursion;

import java.util.ArrayList;

public class ValidParantheses {
    public static void main(String[] args) {
        String s = "())";
        int ind = 2;


        String str = s.substring(0, ind) + s.substring(ind+1, s.length());
        System.out.println(str);
//        System.out.println(removeInvalidParentheses("((((("));
    }

    public static ArrayList<String> removeInvalidParentheses(String s) {
        // code here
        ArrayList<String> list = new ArrayList();

        String str = "a" + s;


        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) != str.charAt(i-1) && isValid(s, i-1)){
                list.add(s.substring(0, i-1) + s.substring(i, s.length()));
            }
        }
        if(isValid(s, s.length())){
            list.add(s);
        }

        return list;
    }

    private static boolean isValid(String s, int ind){

        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            if(i == ind || Character.isLetter(s.charAt(i))) continue;
            if(s.charAt(i) == '(') cnt++;
            if(s.charAt(i) == ')') cnt--;

            if(cnt < 0) return false;
        }

        return cnt == 0;
    }
}
