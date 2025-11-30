package Practice.src.warmup;

public class LeetCode2182 {

    public static void main(String[] args) {

        String res = repeatLimitedString("xyutfpopdynbadwtvmxiemmusevduloxwvpkjioizvanetecnuqbqqdtrwrkgt", 1);
        System.out.println(res);
    }

    public static String repeatLimitedString(String s, int repeatLimit) {

        int[] freq = new int[26];
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int i = 25;
        while (i >= 0) {
            if (freq[i] > 0) {
                int use = Math.min(freq[i], repeatLimit);
                for (int j = 0; j < use; j++) {
                    sb.append((char) (i + 'a'));
                }
                freq[i] -= use;
            }
            if (freq[i] > 0) {
                int j = i - 1;
                while (j >= 0 && freq[j] == 0) {
                    j--;
                }
                if (j == -1) {
                    return sb.toString();
                } else {
                    sb.append((char) (j + 'a'));
                    freq[j]--;
                }
            } else {
                i--;
            }
        }
        return sb.toString();
    }
}
