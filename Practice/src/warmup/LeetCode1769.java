package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode1769 {

    public static void main(String[] args) {

        LeetCode1769 app = new LeetCode1769();
        String boxes = new String("001011");
        int[] ans = app.minOperations(boxes);
        for (int i = 0; i < boxes.length(); i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }

    public int[] minOperations(String boxes) {

        int totalBoxes = boxes.length();
        int[] ans = new int[totalBoxes];
        int numberOfOnes = 0;
        for (int i = 0; i < totalBoxes; i++) {
            if (i > 0) {
                ans[i] = ans[i - 1] + numberOfOnes;
            } else {
                ans[i] = 0;
            }
            if (boxes.charAt(i) == '1') {
                numberOfOnes++;
            }
        }
        numberOfOnes = 0;
        int lastNum = 0;
        for (int i = totalBoxes - 1; i >= 0; i--) {
            if (i + 1 < totalBoxes) {
                lastNum += numberOfOnes;
                ans[i] += lastNum;
            }
            if (boxes.charAt(i) == '1') {
                numberOfOnes++;
            }
        }
        return ans;
    }
}
