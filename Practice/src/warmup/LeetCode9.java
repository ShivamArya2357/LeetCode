package Practice.src.warmup;

public class LeetCode9 {

    public static void main(String[] args) {

        LeetCode9 test = new LeetCode9();
        boolean res = test.isPalindrome(1221);
        System.out.println(res);
    }

    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        } else {
            int temp = x;
            int newNum = 0;
            while (temp > 0) {
                newNum = newNum * 10 + (temp % 10);
                temp /= 10;
            }
            return (newNum == x);
        }
    }
}
