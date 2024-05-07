package recursion;

import java.util.HashMap;

public class PatternMatching {
    public static void main(String[] args) {
        patternMatching("a", "aba");

    }

    private static void patternMatching(String str, String pattern) {
        HashMap<Character, String> map = new HashMap();
        solve(str, pattern, map);

        System.out.println(map);
    }

    private static void solve(String str, String pattern, HashMap<Character, String> map) {
        if(pattern.length() == 0) {
            if (str.length() == 0) {
                System.out.println(map);
            }
            return;
        };

        char ch = pattern.charAt(0);
        String rop = pattern.substring(1);


        if(map.containsKey(ch)){
            String prev = map.get(ch);
            if(str.startsWith(prev)){
                String right = str.substring(prev.length());
                solve(right, rop, map);

            }

        }else{
            for(int i=0; i<str.length(); i++){
                String left = str.substring(0, i+1);
                String right = str.substring(i+1);
                map.put(ch, left);
                solve(right, rop, map);
                map.remove(ch);
            }
        }
    }
}
