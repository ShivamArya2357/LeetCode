package Practice.src.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode811 {

//    public static void main(String[] args) {
//
//        LeetCode811 test = new LeetCode811();
//        String[] cpDomains = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
//        List<String> ans = test.subdomainVisits(cpDomains);
//        for (String val : ans) {
//            System.out.println(val);
//        }
//    }
//
//    public List<String> subdomainVisits(String[] cpDomains) {
//
//        Map<String, Integer> subDomainVisitCount = new HashMap<>();
//        for (String cpDomain : cpDomains) {
//            String[] data = cpDomain.split(" ");
//            String domainName = data[1];
//            Integer visitCount = Integer.parseInt(data[0]);
//            int firstIndex = domainName.indexOf(".");
//            int lastIndex = domainName.lastIndexOf(".");
//            String subDomainName1 = domainName.substring(firstIndex + 1);
//            String subDomainName2 = null;
//            if (firstIndex != lastIndex) {
//                subDomainName2 = domainName.substring(lastIndex + 1);
//            }
//            add(subDomainVisitCount, domainName, visitCount);
//            add(subDomainVisitCount, subDomainName1, visitCount);
//            if (subDomainName2 != null) {
//                add(subDomainVisitCount, subDomainName2, visitCount);
//            }
//        }
//        List<String> ans = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : subDomainVisitCount.entrySet()) {
//            String data = entry.getValue() + " " + entry.getKey();
//            ans.add(data);
//        }
//        return ans;
//    }
//
//    private static void add(Map<String, Integer> subDomainVisitCount, String subDomainName, Integer visitCount) {
//
//        subDomainVisitCount.computeIfPresent(subDomainName,
//                (_, existingVisitCount) -> visitCount + existingVisitCount
//        );
//        subDomainVisitCount.putIfAbsent(subDomainName, visitCount);
//    }
}
