/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

public class TrappingRainWater {

    //Solution1: 先找到最高的，然后分别从两边向中间找
    public static int trapS1(int[] A) {
        if (A.length <= 2) {
            return 0;
        }
        int maxid = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > A[maxid]) {
                maxid = i;
            }
        }
        int water = 0;
        int cur_high = A[0];
        for (int i = 1; i < maxid; i++) {
            if (A[i] > cur_high) {
                cur_high = A[i];
            } else {
                water += cur_high - A[i];
            }
        }
        cur_high = A[A.length - 1];
        for (int i = A.length - 2; i > maxid; i--) {
            if (A[i] > cur_high) {
                cur_high = A[i];
            } else {
                water += cur_high - A[i];
            }
        }
        return water;
    }

    //从边界开始，每次取边界上最矮的板作为往里面floodfill，遇到高的停止。
    public static int trapS2(int[] A) {
        int i = 0;
        int j = A.length - 1;
        int maxWater = 0;
        int cur;
        while (i < j) {
            if (A[i] < A[j]) {
                cur = i + 1;
                while (cur < j && A[cur] <= A[i]) {
                    maxWater += A[i] - A[cur];
                    cur++;
                }
                i = cur;
            } else {
                cur = j - 1;
                while (cur > i && A[cur] <= A[j]) {
                    maxWater += A[j] - A[cur];
                    cur--;
                }
                j = cur;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        int[] input1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] input2 = {1, 2, 3};
        int maxWaterult = trapS2(input2);
        System.out.println(maxWaterult);
    }
}
