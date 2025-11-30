package Practice.src.warmup;

public class LeetCode1061 {

    public static void main(String[] args) {

        LeetCode1061 test = new LeetCode1061();
        String ans = test.smallestEquivalentString("leetcode", "programs", "sourcecode");
        System.out.println(ans);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        int len = s1.length();
        int[] freq = new int[26];
        int[] group = new int[26];
        for (int i = 0; i < len; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (freq[ch1 - 'a'] == 0) {
                freq[ch1 - 'a']++;
            }
            if (freq[ch2 - 'a'] == 0) {
                freq[ch2 - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 1) {
                group[i] = i;
            } else {
                group[i] = -1;
            }
        }
        for (int i = 0; i < len; i++) {
            int index1 = s1.charAt(i) - 'a';
            int index2 = s2.charAt(i) - 'a';
            int groupLead1 = findGroup(index1, group);
            int groupLead2 = findGroup(index2, group);
            if (groupLead1 != groupLead2) {
                if (groupLead1 < groupLead2) {
                    updateGroup(group, groupLead1, index2);
                } else {
                    updateGroup(group, groupLead2, index1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            int index = baseStr.charAt(i) - 'a';
            if (group[index] == -1) {
                sb.append(baseStr.charAt(i));
            } else {
                int groupLead = findGroup(index, group);
                if (index > groupLead) {
                    char ch = (char) (groupLead + 'a');
                    sb.append(ch);
                } else {
                    sb.append(baseStr.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    private int updateGroup(int[] group, int newGroupLead, int index) {

        if (group[index] == index) {
            group[index] = newGroupLead;
            return newGroupLead;
        }
        return group[index] = updateGroup(group, newGroupLead, group[index]);
    }

    private int findGroup(int index, int[] group) {

        if (group[index] == index) {
            return index;
        }
        return findGroup(group[index], group);
    }
}
