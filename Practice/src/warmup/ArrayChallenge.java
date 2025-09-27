package Practice.src.warmup;

import java.util.*;

public class ArrayChallenge {

    public static void main(String[] args) {

        ArrayChallenge test = new ArrayChallenge();
        String ans = ArrayChallenge(new int[]{2,1,1,2,3,3});
        System.out.println(ans);
    }

    public static String ArrayChallenge(int[] arr) {

        Set<List<Integer> > set = new HashSet<>();
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i += 2) {
            List<Integer> pair = Arrays.asList(arr[i], arr[i + 1]);
            if (!set.contains(pair)) {
                Collections.reverse(pair);
                set.add(pair);
            } else {
                set.remove(pair);
            }
        }
        if (set.isEmpty()) {
            return "yes";
        } else {
            for (List<Integer> pair : set) {
                if (!sb.isEmpty()) {
                    sb.append(",");
                }
                sb.append(pair.get(1));
                sb.append(",");
                sb.append(pair.get(0));
            }
            return sb.toString();
        }
    }

}
