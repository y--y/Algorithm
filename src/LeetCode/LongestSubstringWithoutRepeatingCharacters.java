/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int end = 0; end < s.length(); end++) {
            if (map.containsKey(s.charAt(end)) && map.get(s.charAt(end)) >= start) {
                start = map.get(s.charAt(end)) + 1;
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters caller = new LongestSubstringWithoutRepeatingCharacters();
        String input = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        int result = caller.lengthOfLongestSubstring(input);
        System.out.println(result);
    }
}
