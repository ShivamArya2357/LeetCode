package Practice.src.warmup;

public class LeetCode2024 {

    public static void main(String[] args) {

        LeetCode2024 test = new LeetCode2024();
        int ans = test.maxConsecutiveAnswers("TTFTFFFTFFTT", 2);
        System.out.println(ans);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {

        return Math.max(func(answerKey, k, 'T'), func(answerKey, k, 'F'));
    }

    private int func(String answerKey, int k, char ch) {

        int len = answerKey.length();
        int count = 0;
        int ans = 0;
        int start = 0;
        for (int i = 0; i < len;) {
            if (answerKey.charAt(i) == ch) {
                count++;
            }
            if (count == k) {
                int tempAns = i - start + 1;
                i++;
                while (i < len && answerKey.charAt(i) != ch) {
                    i++;
                    tempAns++;
                }
                ans = Math.max(ans, tempAns);
                if (answerKey.charAt(start) == ch) {
                    start++;
                } else {
                    while (start < len && answerKey.charAt(start) != ch) {
                        start++;
                    }
                    start++;
                }
                count--;
            } else {
                ans = Math.max(ans, i - start + 1);
                i++;
            }
        }
        return ans;
    }
}
