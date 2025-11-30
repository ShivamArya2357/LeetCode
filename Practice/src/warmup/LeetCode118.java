package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {

    public static void main(String[] args) {

        LeetCode118 test = new LeetCode118();
        List<List<Integer>> res = test.generate(5);
        System.out.println(res);
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> prevList = new ArrayList<>();
        prevList.add(1);
        res.add(prevList);
        while (numRows > 1) {
            List<Integer> tempList = new ArrayList<>();
            if (prevList.size() > 1) {
                tempList.add(1);
                for (int i = 0; i < prevList.size() - 1; i++) {
                    tempList.add(prevList.get(i) + prevList.get(i + 1));
                }
                tempList.add(1);
            } else {
                tempList.add(1);
                tempList.add(1);
            }
            res.add(tempList);
            prevList = tempList;
            numRows--;
        }
        return res;
    }
}
