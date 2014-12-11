/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class SubstringwithConcatenationofAllWords {

    public List<Integer> findSubstring(String S, String[] L) {
        int length = L.length * L[0].length();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            if (map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int start = 0; start <= S.length() - length; start++) {
            int end = start + length;
            String cur = S.substring(start, end);
            if (equal(cur, L[0].length(), map)) {
                result.add(start);
            }
        }
        return result;
    }

    private boolean equal(String str, int unit, HashMap<String, Integer> map) {
        HashMap<String, Integer> mapCopy = (HashMap<String, Integer>) map.clone();
        for (int i = 0; i < str.length() / unit; i++) {
            String cur = str.substring(i * unit, (i + 1) * unit);
            if (!mapCopy.containsKey(cur)) {
                return false;
            } else {
                if (mapCopy.get(cur) == 1) {
                    mapCopy.remove(cur);
                } else {
                    mapCopy.put(cur, mapCopy.get(cur) - 1);
                }
            }
        }
        return mapCopy.isEmpty();
    }

    public static void main(String[] args) {
        SubstringwithConcatenationofAllWords caller = new SubstringwithConcatenationofAllWords();
        String S = "barfoothefoobarman";
        String[] L = {"foo", "bar"};
        List<Integer> result = caller.findSubstring(S, L);
        System.out.println(result);
    }
}
