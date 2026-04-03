package Practice.src.warmup;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        int[][] arr = new int[5][];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int size = random.nextInt(6);
            size++;
            arr[i] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[i][j] = j + 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
