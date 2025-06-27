package Practice.src.warmup;

public class LeetCode258 {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        } else if (num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }
}
