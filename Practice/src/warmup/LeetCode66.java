package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode66 {

    public int[] plusOne(int[] digits) {

        int totalDigits = digits.length;
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = totalDigits - 1; i >= 0; i--) {
            int temp = 0;
            if (i == totalDigits - 1) {
                temp = digits[i] + 1;
            } else {
                temp = carry + digits[i];
            }
            int newDigit = (temp) % 10;
            carry = (temp) / 10;
            res.add(newDigit);
        }
        if (carry > 0) {
            res.add(carry);
        }
        int newLen = res.size();
        int[] ans = new int[newLen];
        for (int i = 0; i < newLen; i++) {
            ans[i] = res.get(newLen - i - 1);
        }
        return ans;
    }
}
