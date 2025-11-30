package Practice.src.warmup;

public class LeetCode3271 {

    public static void main(String[] args) {

        LeetCode3271 test = new LeetCode3271();
        String ans = test.stringHash("abcd", 2);
        System.out.println(ans);
    }

    public String stringHash(String s, int k) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            String temp = s.substring(i, i + k);
            int sum = 0;
            for (int j = 0; j < temp.length(); j++) {
                sum += temp.charAt(j) - 'a';
            }
            int remainder = sum % 26;
            sb.append((char) (remainder + 'a'));
        }
        return sb.toString();
    }
}
