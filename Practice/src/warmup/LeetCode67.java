package Practice.src.warmup;

public class LeetCode67 {

    public static void main(String[] args) {

        LeetCode67 test = new LeetCode67();
        String res = test.addBinary("10", "1011");
        System.out.println(res);
    }

    public String addBinary(String a, String b) {

        int n = a.length();
        int m = b.length();
        int i = n - 1;
        int j = m - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int currDigit1 = a.charAt(i) - '0';
            int currDigit2 = b.charAt(j) - '0';
            int newCarry = (carry + currDigit1 + currDigit2) / 2;
            int newResult = (carry + currDigit1 + currDigit2) % 2;
            carry = newCarry;
            sb.append(newResult);
            i--;
            j--;
        }
        while (i >= 0) {
            int currDigit1 = a.charAt(i) - '0';
            int newCarry = (carry + currDigit1) / 2;
            int newResult = (carry + currDigit1) % 2;
            carry = newCarry;
            sb.append(newResult);
            i--;
        }
        while (j >= 0) {
            int currDigit2 = b.charAt(j) - '0';
            int newCarry = (carry + currDigit2) / 2;
            int newResult = (carry + currDigit2) % 2;
            carry = newCarry;
            sb.append(newResult);
            j--;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
