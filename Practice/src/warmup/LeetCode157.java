package Practice.src.warmup;

import java.util.Random;

public class LeetCode157 {

    public static void main(String[] args) {

    }

    int read(char[] buf, int n) {

        int totalActualCharactersRead = 0;
        int j = 0;
        char[] newBuf = new char[4];
        while (totalActualCharactersRead < n) {
            int noOfCharactersRead = read4(newBuf);
            if (noOfCharactersRead == 0) {
                break;
            }
            for (int i = 0; totalActualCharactersRead < n && i < noOfCharactersRead; i++) {
                buf[totalActualCharactersRead++] = newBuf[i];
            }
        }
        return totalActualCharactersRead;
    }

    int read4(char[] buf4) {
        return new Random().nextInt(5);
    }
}
