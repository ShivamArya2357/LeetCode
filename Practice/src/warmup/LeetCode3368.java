package Practice.src.warmup;

public class LeetCode3368 {

    public static void main(String[] args) {

        LeetCode3368 test = new LeetCode3368();
        String ans = test.capitalise("hello world");
        System.out.println(ans);
    }

    public String capitalise(String words) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length(); ) {
            while (i < words.length() && words.charAt(i) == ' ') {
                sb.append(words.charAt(i));
                i++;
            }
            boolean isFirstChar = true;
            while (i < words.length() && words.charAt(i) != ' ') {
                if (isFirstChar) {
                    sb.append(Character.toUpperCase(words.charAt(i)));
                    isFirstChar = false;
                } else {
                    sb.append(words.charAt(i));
                }
                i++;
            }
        }
        return sb.toString();
    }
}
