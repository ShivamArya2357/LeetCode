package Practice.src.warmup;

import java.util.*;

public class LeetCode1233 {

    public static void main(String[] args) {

        String[] folders = new String[]{"/a","/a/b/c","/a/b/ca","/a/b/d"};
        List<String> res = removeSubfolders(folders);
        for (String filePath : res) {
            System.out.println(filePath);
        }
    }

//    public static List<String> removeSubfolders(String[] folders) {
//
//        Set<String> set = new HashSet<>();
//        for (String filePath : folders) {
//            set.add(filePath);
//        }
//        for (String filePath : folders) {
//            String originalFilePath = filePath;
//            while (filePath.lastIndexOf("/") != -1) {
//                int index = filePath.lastIndexOf("/");
//                filePath = filePath.substring(0, index);
//                if (set.contains(filePath)) {
//                    set.remove(originalFilePath);
//                    break;
//                }
//            }
//        }
//        List<String> res = new ArrayList<>();
//        for (String filePath : set) {
//            res.add(filePath);
//        }
//        return res;
//    }

    public static List<String> removeSubfolders(String[] folders) {

        Arrays.sort(folders);
        List<String> res = new ArrayList<>();
        res.add(folders[0]);
        for (int i = 1; i < folders.length; i++) {
            String lastFolder = res.get(res.size() - 1) + "/";
            if (!folders[i].startsWith(lastFolder)) {
                res.add(folders[i]);
            }
        }
        return res;
    }
}
