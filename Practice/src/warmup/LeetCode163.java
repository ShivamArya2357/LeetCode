package Practice.src.warmup;

import java.util.ArrayList;
import java.util.List;

public class LeetCode163 {

    public static void main(String[] args) {

        LeetCode163 test = new LeetCode163();
        int[] arr = new int[]{-48, -10, -6, -4, 0, 4, 17};
        int l = -54;
        int h = 17;
        List<List<Integer> > ranges = test.findMissingRanges(arr, l, h);
        for (List<Integer> range : ranges) {
            for (Integer element : range) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer> > findMissingRanges(int[] arr, int l, int h) {

        int n = arr.length;
        int expectedNextNumber = l;
        List<List<Integer> > ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] >= l && arr[i] <= h) {
                List<Integer> range = new ArrayList<>();
                if (arr[i] != expectedNextNumber) {
                    range.add(expectedNextNumber);
                    range.add(arr[i] - 1);
                    ranges.add(range);
                }
                expectedNextNumber = arr[i] + 1;
            } else {
                break;
            }
        }
        if (expectedNextNumber <= h) {
            List<Integer> range = new ArrayList<>();
            range.add(expectedNextNumber);
            range.add(h);
            ranges.add(range);
        }
        return ranges;
    }
}
