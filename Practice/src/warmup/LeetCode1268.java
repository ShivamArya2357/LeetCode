package Practice.src.warmup;

import java.util.*;

public class LeetCode1268 {

    public static void main(String[] args) {

        LeetCode1268 test = new LeetCode1268();
        String[] products = {"bags","baggage","banner","box","cloths"};
        String searchWord = "bags";
        List<List<String>> res = test.suggestedProducts2(products, searchWord);
//        for (List<String> words : res) {
//            for (String word : words) {
//                System.out.print(word + " ");
//            }
//            System.out.println();
//        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Map<String, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < products.length; j++) {
            String product = products[j];
            int len = product.length();
            for (int i = 1; i <= len; i++) {
                String substr = product.substring(0, i);
                List<Integer> temp = map.getOrDefault(substr, new ArrayList<>());
                temp.add(j);
                map.put(substr, temp);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String substr = searchWord.substring(0, i);
            List<Integer> temp = map.get(substr);
            List<String> words = new ArrayList<>();
            if (!temp.isEmpty()) {
                for (int j = 0; j < temp.size(); j++) {
                    int index = temp.get(j);
                    words.add(products[index]);
                }
                Collections.sort(words);
            }
            if (words.size() > 3) {
                res.add(words.subList(0, 3));
            } else {
                res.add(words);
            }
        }
        return res;
    }

    public List<List<String>> suggestedProducts2(String[] products, String searchWord) {

        Arrays.sort(products);
        for (String product : products) {
            System.out.print(product + " ");
        }
        System.out.println();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 1; i <= searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i);
            int index = binarySearch(products, prefix);
            List<String> temp = new ArrayList<>();
            if (index != -1) {
                for (int j = index; j < index + 3 && j < products.length; j++) {
                    if (products[j].startsWith(prefix)) {
                        temp.add(products[j]);
                    }
                }
            }
            ans.add(temp);
        }
        return ans;
    }

    private int binarySearch(String[] products, String prefix) {

        int l = 0;
        int h = products.length - 1;
        int index = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (prefix.compareTo(products[mid]) <= 0) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return index;
    }
}
