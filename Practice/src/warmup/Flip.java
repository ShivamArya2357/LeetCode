package Practice.src.warmup;

public class Flip {

    public static void main(String[] args) {

        Flip test = new Flip();
        String A = "1101010001";
        int[] ans = test.flip(A);
        System.out.println(ans[0] + " " + ans[1]);
    }

    public int[] flip(String A) {

        int countOfOnes = 0;
        int n = A.length();
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '1') {
                countOfOnes++;
            }
        }
        int countOfZeroes = 0;
        int l = -1;
        int r = -1;
        int maxCountOfOnes = countOfOnes;
        for (int i = 0; i < n; i++) {
            if (A.charAt(i) == '0') {
                countOfZeroes++;
                if (countOfZeroes + countOfOnes > maxCountOfOnes) {
                    maxCountOfOnes = countOfZeroes + countOfOnes;
                    r = i;
                    l = r - countOfZeroes + 1;
                }
            } else {
                countOfZeroes = 0;
            }
        }
        if (l == -1) {
            return new int[]{};
        }
        return new int[]{l + 1, r + 1};
    }
}
