/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class ThreeSum {

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            twoSum(num, i, i + 1, num.length - 1);

        }
        return results;
    }

    private void twoSum(int[] num, int i, int left, int right) {
        int target = 0 - num[i];
        while (left < right) {
            int curSum = num[left] + num[right];
            if (curSum < target) {
                left++;
                while (left < right && num[left] == num[left - 1]) {
                    left++;
                }
            } else if (curSum > target) {
                right--;
                while (left < right && num[right] == num[right + 1]) {
                    right--;
                }
            } else {
                List<Integer> result = new ArrayList<Integer>(Arrays.asList(num[i], num[left], num[right]));
                results.add(result);
                left++;
                right--;
                while (left < right && num[left] == num[left - 1]) {
                    left++;
                }
                while (left < right && num[right] == num[right + 1]) {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSum caller = new ThreeSum();
        int num[] = {-2, 0, 0, 2, 2};
        List<List<Integer>> output = caller.threeSum(num);
        System.out.print(output);
    }
}
