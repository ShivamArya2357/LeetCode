package Practice.src.warmup;

import java.util.BitSet;

public class LeetCode2429 {

    public static void main(String[] args) {

        LeetCode2429 test = new LeetCode2429();
        int ans = test.minimizeXor(8, 13);
        System.out.println(ans);
    }

    public int minimizeXor(int num1, int num2) {

        int setBits1 = Integer.bitCount(num1);
        int setBits2 = Integer.bitCount(num2);
        BitSet newNum = null;
        if (setBits1 == setBits2) {
            return num1;
        } else if (setBits1 < setBits2) {
            newNum = getBitSet(num1);
            for (int i = 31; i >= 0 && setBits1 < setBits2; i--) {
                if (!newNum.get(i)) {
                    newNum.set(i, true);
                    setBits1++;
                }
            }
        } else {
            newNum = getBitSet(num1);
            int count = 0;
            for (int i = 0; i < 32; i++) {
                if (count < setBits2 && newNum.get(i)) {
                    count++;
                } else if (newNum.get(i)) {
                    newNum.clear(i);
                }
            }
        }
        return getDecimalNumber(newNum);
    }

    private static BitSet getBitSet(int num) {

        BitSet newNum = new BitSet(32);
        int index = 31;
        while (num > 0) {
            if (num % 2 == 1) {
                newNum.set(index);
            } else {
                newNum.clear(index);
            }
            num /= 2;
            index--;
        }
        return newNum;
    }

    private int getDecimalNumber(BitSet newNum) {

        int finalNum = 0;
        for (int i = 0; i < 32; i++) {
            if (newNum.get(i)) {
                finalNum += (1 << (31 - i));
            }
        }
        return finalNum;
    }
}
