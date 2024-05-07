package string;

import static java.util.Objects.hash;

public class KarpRabin {
    public static void main(String[] args) {
        String str = "mynameisshiva";
        String pattern = "shiva";

        int n = str.length();
        int m = pattern.length();

        System.out.println(str.substring(0,m));

        int strHash = hash(str.substring(0,m));
        int patternHash = hash(pattern);

        if(strHash == patternHash && pattern.equals(str.substring(0, m))) {
            System.out.println("Found at index " + 0);
        }

        for(int i=1; i<=n-m; i++){
            strHash -= hash(str.charAt(i-1));
            strHash += hash(str.charAt(i+m-1));

            System.out.println(str.substring(i, i+m));
            if(strHash == patternHash && pattern.equals(str.substring(i, i+m))){
                System.out.println("Found at index " + i);
                break;
            }

        }
    }
}
