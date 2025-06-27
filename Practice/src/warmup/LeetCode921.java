package Practice.src.warmup;

public class LeetCode921 {

    public static void main(String[] args) {

    }

    public static int minAddToMakeValid(String s) {

        int len = s.length();
        int ans = 0;
        int openBrackets = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                openBrackets++;
            } else {
                if (openBrackets > 0) {
                    openBrackets--;
                } else {
                    ans++;
                }
            }
        }
        return ans + openBrackets;
    }
}
