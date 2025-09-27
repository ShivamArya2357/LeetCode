package Practice.src.warmup;

public class LeetCode2259 {

    public static void main(String[] args) {

    }

    public String removeDigit(String number, char digit) {

        int len = number.length();
        String res = "";
        for (int i = 0; i < len; i++) {
            if (number.charAt(i) == digit) {
                String firstPart = number.substring(0, i);
                String secondPart = number.substring(i + 1);
                String newStr = firstPart + secondPart;
                if (res.compareTo(newStr) < 0) {
                    res = newStr;
                }
            }
        }
        return res;
    }
}
