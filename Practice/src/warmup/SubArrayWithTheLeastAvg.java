package Practice.src.warmup;

public class SubArrayWithTheLeastAvg {

    public static void main(String[] args) {

        SubArrayWithTheLeastAvg test = new SubArrayWithTheLeastAvg();
        int[] A = {3, 7, 5, 20, -10, 0, 12};
        int B = 2;
        int ans = test.solve(A, B);
        System.out.println(ans);
    }

    public int solve(int[] A, int B) {

        int n = A.length;
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        int minSum = sum;
        int i = 1;
        int j = B;
        int index = 0;
        while (j < n) {
            sum = sum - A[i - 1] + A[j];
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
            i++;
            j++;
        }
        return index;
    }
}
