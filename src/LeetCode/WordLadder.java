package LeetCode;

import java.util.*;

public class WordLadder {

    public static int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        List<String> queue = new ArrayList<String>();
        queue.add(start);
        int length = 0;
        while (!queue.isEmpty()) {
            length++;
            List<String> queueCopy = new ArrayList<String>(queue);
            queue.clear();
            for (String curStr : queueCopy) {
                if (curStr.equals(end)) {
                    return length;
                }
                for (int i = 0; i < curStr.length(); i++) {
                    char[] curChar = curStr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        curChar[i] = c;
                        String newStr = new String(curChar);
                        if (dict.contains(newStr)) {
                            queue.add(newStr);
                            dict.remove(newStr);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");

        int result = ladderLength(start, end, dict);
        System.out.println(result);
    }
}
