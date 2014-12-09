/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class FourSum {

    List<List<Integer>> results = new ArrayList<List<Integer>>();

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j != i + 1 && num[j] == num[j - 1]) {
                    continue;
                }
                twoSum(num, i, j, j + 1, num.length - 1, target);
            }
        }
        return results;
    }

    private void twoSum(int[] num, int i, int j, int left, int right, int target) {
        while (left < right) {
            int curSum = num[i] + num[j] + num[left] + num[right];
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
            } else if (curSum == target) {
                List<Integer> result = new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[left], num[right]));
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
        FourSum caller = new FourSum();
        int num[] = {-1, 0, 1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> output = caller.fourSum(num, target);
        System.out.println(output);
    }
}
