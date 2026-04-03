package Practice.src.warmup;

public class SecondLargestElement {

    public static void main(String[] args) {

    }

    public int solve(int[] A) {

        int firstLargest = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            firstLargest = Math.max(firstLargest, A[i]);
        }
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (firstLargest != A[i]) {
                secondLargest = Math.max(secondLargest, A[i]);
            }
        }
        return secondLargest != Integer.MIN_VALUE ? secondLargest : -1;
    }
}
