package Practice.src.warmup;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CodingChallenge {

    public static void main(String[] args) {

        String res = CodingChallenge(new String[] {"Brad Pitt","Leonardo DiCaprio","Charlize Theron"});
        System.out.println(res);
    }

    public static String CodingChallenge(String[] names) {

        List<NamePair> namePairs = new ArrayList<>();
        for (String name : names) {
            String[] tokens = name.split("\\s+");
            String lastName = tokens[tokens.length - 1];
            int[] freq = new int[128];
            for (int i = 0; i < lastName.length(); i++) {
                freq[lastName.charAt(i)]++;
            }
            int heighestFreq = 0;
            for (int i = 0; i < 128; i++) {
                heighestFreq = Math.max(heighestFreq, freq[i]);
            }
            namePairs.add(new NamePair(name, heighestFreq, lastName, tokens));
        }
        namePairs.sort(
                Comparator
                        .comparingInt(NamePair::getHighestFreq)
                        .thenComparing(NamePair::getLastName)
                        .thenComparing((a, b) -> compareTokens(a.getTokens(), b.getTokens()))
        );
        return namePairs.stream().map(NamePair::getName).collect(Collectors.joining(", "));
    }

    private static int compareTokens(String[] a, String[] b) {

        int len = Math.min(a.length, b.length);
        for (int i = 0; i < len; i++) {
            int cmp = a[i].compareTo(b[i]);
            if (cmp != 0) return cmp;
        }
        return Integer.compare(a.length, b.length);
    }

    static class NamePair {

        final String name;
        final int highestFreq;
        final String lastName;
        final String[] tokens;

        NamePair(String name, int highestFreq, String lastName, String[] tokens) {
            this.name = name;
            this.highestFreq = highestFreq;
            this.lastName = lastName;
            this.tokens = tokens;
        }

        public String getName() {
            return name;
        }

        public int getHighestFreq() {
            return highestFreq;
        }

        public String getLastName() {
            return lastName;
        }

        public String[] getTokens() {
            return tokens;
        }
    }
}
