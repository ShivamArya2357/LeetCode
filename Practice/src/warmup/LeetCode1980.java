package Practice.src.warmup;

public class LeetCode1980 {

    public static void main(String[] args) {

        LeetCode1980 test = new LeetCode1980();
        String[] nums = new String[]{"1011","1010","1001"};
        String ans = test.findDifferentBinaryString(nums);
        System.out.println(ans);
    }

//    public String findDifferentBinaryString(String[] nums) {
//
//        Set<Integer> set = new HashSet<>();
//        for (String binaryNum : nums) {
//            int decimalNum = getDecimalNum(binaryNum);
//            set.add(decimalNum);
//        }
//        int maxNum = (1 << nums.length);
//        for (int i = 1; i <= maxNum; i++) {
//            if (!set.contains(i)) {
//                return getBinaryNum(i, nums.length);
//            }
//        }
//        int paddingZerosCount = nums.length;
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < paddingZerosCount; i++) {
//            sb.append("0");
//        }
//        return sb.toString();
//    }
//
//    private String getBinaryNum(int decimalNum, int len) {
//
//        StringBuilder sb = new StringBuilder();
//        while (decimalNum > 0) {
//            sb.append(decimalNum % 2);
//            decimalNum /= 2;
//        }
//        int paddingZerosCount = len - sb.length();
//        for (int i = 0; i < paddingZerosCount; i++) {
//            sb.append("0");
//        }
//        return sb.reverse().toString();
//    }
//
//    private int getDecimalNum(String binaryNum) {
//
//        int decimalNum = 0;
//        int len = binaryNum.length();
//        for (int i = len - 1; i >= 0; i--) {
//            if (binaryNum.charAt(i) == '1') {
//                decimalNum += (1 << (len - i - 1));
//            }
//        }
//        return decimalNum;
//    }

    public String findDifferentBinaryString(String[] nums) {

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i].charAt(i) == '0') {
                ans.append("1");
            } else {
                ans.append("0");
            }
        }
        return ans.toString();
    }
}
