package string;

public class CoundAndSay {
    public static void main(String[] args) {
        String s = "abaaaa";
        int count = 1;
        String ans = "";
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                ans += count + "" + s.charAt(i);
                count = 1;
            }
        }
        ans += count + "" + s.charAt(s.length()-1);
        System.out.println(ans);
    }

}
