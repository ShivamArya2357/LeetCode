package Practice.src.warmup;

public class LeetCode147 {

    public static void main(String[] args) {

        boolean ans = hasMatch("ckckkk", "ck*kc");
        System.out.println(ans);
    }

    public static boolean hasMatch(String s, String p) {

        int index = p.indexOf("*");
        String first = p.substring(0, index);
        String second = p.substring(index + 1);
        if (!first.isEmpty() && !second.isEmpty()) {
            int index1 = s.indexOf(first);
            if (index1 != -1) {
                int index2 = s.indexOf(second, index1 + first.length());
                if (index2 != -1) {
                    return true;
                }
            }
            return false;
        } else if (!first.isEmpty()) {
            int index1 = s.indexOf(first);
            if (index1 != -1) {
                return true;
            }
            return false;
        } else if (!second.isEmpty()) {
            int index1 = s.indexOf(second);
            if (index1 != -1) {
                return true;
            }
            return false;
        } else {
            return true;
        }
    }
}
