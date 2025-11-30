package Practice.src.warmup;

public class LeetCode14 {

    public static void main(String[] args) {

        LeetCode14 test = new LeetCode14();
        String res = test.longestCommonPrefix(new String[]{"flow","flower","florish"});
        System.out.println(res);
    }

    public String longestCommonPrefix(String[] strs) {

        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            Character currentChar = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String currentStr = strs[j];
                if (i >= currentStr.length() || !currentChar.equals(currentStr.charAt(i))) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
}
