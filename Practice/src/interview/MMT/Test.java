package Practice.src.interview.MMT;

//You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
//
//Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
//
//You may assume that you have an infinite number of each kind of coin.
//
//The answer is guaranteed to fit into a signed 32-bit integer.
//
//Example 1:
//
//Input: amount = 5, coins = [1,2,5]
//
//Output: 4
//
//Explanation: there are four ways to make up the amount:
//
//        5=5
//
//        5=2+2+1
//
//        5=2+1+1+1
//
//        5=1+1+1+1+1
//
//Example 2:
//
//Input: amount = 3, coins = [2]
//
//Output: 0
//
//Explanation: the amount of 3 cannot be made up just with coins of 2.
//
//Example 3:
//
//Input: amount = 10, coins = [10]
//
//Output: 1


import java.util.HashSet;
import java.util.Set;

public class Test {

//    public static void main(String[] args) {
//
//        Test test = new Test();
//        int amount = 10;
//        int[] coins = {10};
//        int n = coins.length;
//        int ans = test.numberOfCombinations(amount, 0, n, coins);
//        System.out.println(ans);
//    }

    public int numberOfCombinations(int amount, int i, int n, int[] coins) {

        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || i >= n) {
            return 0;
        }
        return numberOfCombinations(amount - coins[i], i, n, coins) +
                numberOfCombinations(amount, i + 1, n, coins);
    }

//    Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//    Note that the same word in the dictionary may be reused multiple times in the segmentation.
//
//    Example 1:
//
//    Input: s = "netradyne", wordDict = ["netra","dyne"]
//
//    Output: true
//
//    Explanation: Return true because "netradyne" can be segmented as "netra dyne".
//
//    Example 2:
//
//    Input: s = "applepenapple", wordDict = ["apple","pen"]
//
//    Output: true
//
//    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//
//    Note that you are allowed to reuse a dictionary word.
//
//    Example 3:
//
//    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//
//    Output: false

//    public static void main(String[] args) {
//
//        Test test = new Test();
//        String s = "netradyne";
//        String[] wordDict = {"netra", "dyne"};
//        boolean ans = test.canBeSplitted(s, wordDict);
//        System.out.println(ans);
//    }

    public boolean canBeSplitted(String s, String[] wordDict) {

        Set<String> dictSet = new HashSet<>();
        for (String word : wordDict) {
            dictSet.add(word);
        }
        boolean ans = helper(s, wordDict, dictSet);
        return ans;
    }

    public boolean helper(String s, String[] wordDict, Set<String> dictSet) {

        if (s.isEmpty()) {
            return true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String substr = s.substring(0, i);
            if (dictSet.contains(substr)) {
                String secondSubstr = s.substring(i);
                if (helper(secondSubstr, wordDict, dictSet)) {
                    return true;
                }
            }
        }
        return false;
    }

//    You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//    Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//            Example 1:
//
//    Input: nums = [1,2,3,1]
//
//    Output: 4
//
//    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//
//    Total amount you can rob = 1 + 3 = 4.
//
//    Example 2:
//
//    Input: nums = [2,7,9,3,1]
//
//    Output: 12
//
//    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//
//    Total amount you can rob = 2 + 9 + 1 = 12.
//
//    Example 3:
//
//    Input: nums = [5,2,3,9]
//
//    Output: 14
//
//    Explanation: Rob house 1 (money = 5), rob house 4 (money = 9).
//
//    Total amount you can rob = 5 + 9 = 14.

    public static void main(String[] args) {

        Test test = new Test();
        int[] nums = {5,2,3,9};
        int n = nums.length;
        int ans = test.findMaxMoney(nums, n);
        System.out.println(ans);
    }

    public int findMaxMoney(int[] nums, int n) {

        return helper(nums, 0, n);
    }


    public int helper(int[] nums, int i, int n) {

        if (i >= n) {
            return 0;
        }
        return Math.max(nums[i] + helper(nums, i + 2, n), helper(nums, i + 1, n));
    }
}
