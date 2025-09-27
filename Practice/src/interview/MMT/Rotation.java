package Practice.src.interview.MMT;

/**
 * Write a function that returns True if one array is a rotation of another.
 * Example: [1, 2, 3, 4, 5, 6, 7] is a rotation of [4, 5, 6, 7, 1, 2, 3].
 * 1#2#3#4#5#6#7#
 * 4#5#6#7#1#2#3#4#5#6#7#1#2#3#
 *
 * [7, 1, 2, 3, 4, 5, 6] is a rotation of [4, 5, 6, 7, 1, 2, 3]
 *
 * [11, 10, 1, 3, 7] is a rotation of [1, 3, 7, 11, 10]
 *
 * [10, 11, 3, 1, 7] is a rotation of [3, 1, 7, 10, 11]
 *
 * [12, 10, 3, 1, 7] is a rotation of [3, 1, 7, 10, 11]
 */
public class Rotation {

    public static void main(String[] args) {

        Rotation test = new Rotation();
        int[] a = {12, 10, 3, 1, 7};
        int[] b = {3, 1, 7, 10, 11};
        boolean ans = test.isRotation(a, b);
        System.out.println(ans);
    }

//    public boolean isRotation(int[] a, int[] b) {
//
//        int n = a.length;
//        int m = b.length;
//        if (n != m) {
//            return false;
//        } else {
//            int i = 0;
//            int j = 0;
//            boolean firstMatch = false;
//            while (i < n) {
//                if (a[i] == b[j]) {
//                    i++;
//                    j = (j + 1) % n;
//                    if (!firstMatch) {
//                        firstMatch = true;
//                    }
//                } else {
//                    if (firstMatch) {
//                        return false;
//                    }
//                    if (j == (n - 1) && !firstMatch) {
//                        return false;
//                    }
//                    j = (j + 1) % n;
//                }
//            }
//            return true;
//        }
//    }

    public boolean isRotation(int[] a, int[] b) {

        int n = a.length;
        int m = b.length;
        if (n != m) {
            return false;
        } else {
            String s1 = toKey(a);
            String s2 = toKey(b);
            return (s2 + "#" + s2).contains(s1);
        }
    }

    private String toKey(int[] a) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append("#");
            }
            sb.append(a[i]);
        }
        return sb.toString();
    }
}
