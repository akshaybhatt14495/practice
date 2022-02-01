package leetcode;

import java.util.*;

public class Paragraph {
    public static void main(String[] args) {
        System.out.println(new Paragraph().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }
    public String mostCommonWord(String paragraph, String[] banned) {

        StringBuilder sb = new StringBuilder();
        Set<String> bannedSet = new HashSet<>();

        for (String s: banned) {
            bannedSet.add(s);
        }
        Map<String, Integer> aggr =new HashMap<>();
        for (int i=0; i< paragraph.length();i++) {

            if (!(paragraph.charAt(i)=='!' ||paragraph.charAt(i)=='?' ||paragraph.charAt(i)=='\'' ||paragraph.charAt(i)==',' ||paragraph.charAt(i)==';' ||paragraph.charAt(i)=='.'|| paragraph.charAt(i)==' ')) {
                sb.append(paragraph.charAt(i));
            } else if (paragraph.charAt(i) == ' ') {
                String word = sb.toString().toLowerCase();
                sb = new StringBuilder();
                if (!bannedSet.contains(word)) {
                    aggr.put(word, aggr.getOrDefault(word, 0) +1);
                }
            }

        }
        String word = sb.toString();
        if (!bannedSet.contains(word)) {
            aggr.put(word, aggr.getOrDefault(word, 0) +1);
        }
        String result=""; int maxCount=0;
        for (Map.Entry<String, Integer> entry:  aggr.entrySet()) {
            if (entry.getValue()>maxCount) {
                maxCount=entry.getValue();
                result=entry.getKey();
            }
        }
        return result;
    }
}
