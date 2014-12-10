/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

public class MinimumWindowSubstring {

    public String minWindow(String S, String T) {
        int[] text = new int[128];
        int[] pattern = new int[128];

        for (int i = 0; i < T.length(); i++) {
            pattern[T.charAt(i)]++;
        }
        int start = 0;
        int min = Integer.MAX_VALUE;
        Integer minStart = null;
        Integer minEnd = null;
        for (int end = 0; end < S.length(); end++) {
            text[S.charAt(end)]++;
            if (contain(text, pattern)) {
                while (contain(text, pattern)) {
                    text[S.charAt(start)]--;
                    start++;
                }
                if (end - (start - 1) + 1 < min) {
                    min = end - (start - 1) + 1;
                    minStart = start - 1;
                    minEnd = end;
                }
            }
        }

        if (minStart != null && minEnd != null) {
            return S.substring(minStart, minEnd + 1);
        } else {
            return "";
        }
    }

    private boolean contain(int[] text, int[] pattern) {
        for (int i = 0; i < 128; i++) {
            if (pattern[i] != 0 && text[i] < pattern[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring caller = new MinimumWindowSubstring();
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String result = caller.minWindow(S, T);
        System.out.println(result);
    }
}
