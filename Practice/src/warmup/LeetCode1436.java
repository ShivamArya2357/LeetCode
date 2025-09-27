package Practice.src.warmup;

import java.util.*;

public class LeetCode1436 {

    public static void main(String[] args) {

    }

//    public String destCity(List<List<String>> paths) {
//
//        Map<String, Integer> map = new HashMap<>();
//        for (List<String> path : paths) {
//            String source = path.get(0);
//            String dest = path.get(1);
//            map.put(source, map.getOrDefault(source, 0) + 1);
//            map.put(dest, map.getOrDefault(dest, 0) + 1);
//        }
//        for (List<String> path : paths) {
//            String dest = path.get(1);
//            if (map.get(dest) == 1) {
//                return dest;
//            }
//        }
//        return "";
//    }

    public String destCity(List<List<String>> paths) {

        int prevDestIndex = -1;
        String currSource = null;
        String currDest = null;
        for (int i = 0; i < paths.size(); i++) {
            List<String> path = paths.get(i);
            currSource = path.get(0);
            currDest = path.get(1);
            if (isSame(currSource, prevDestIndex, paths)) {
                prevDestIndex = i;
            }
            if (prevDestIndex == -1) {
                prevDestIndex = i;
            }
        }
        return paths.get(prevDestIndex).get(1);
    }

    private boolean isSame(String currSource, int prevDestIndex, List<List<String>> paths) {

        if (prevDestIndex != -1) {
            List<String> path = paths.get(prevDestIndex);
            String prevDest = path.get(1);
            return currSource.equals(prevDest);
        }
        return false;
    }
}
