/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class ThreeSumClosest {

    Integer closest = null;

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        for (int i = 0; i <= num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }
            twoSum(num, i, i + 1, num.length - 1, target);
        }
        return closest;
    }

    private void twoSum(int[] num, int i, int left, int right, int target) {
        while (left < right) {
            int curSum = num[i] + num[left] + num[right];
            if (closest == null || Math.abs(curSum - target) < Math.abs(closest - target)) {
                closest = curSum;
            }
            if (curSum <= target) {
                left++;
                while (left < right && num[left] == num[left - 1]) {
                    left++;
                }
            } else if (curSum > target) {
                right--;
                while (left < right && num[right] == num[right + 1]) {
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreeSumClosest caller = new ThreeSumClosest();
        int num[] = {1, 1, -1, -1, 3};
        int result = caller.threeSumClosest(num, -1);
        System.out.print(result);
    }
}
