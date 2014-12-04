package Problems;

import DataStructureHelper.TreeNode;
import java.util.*;

public class GetAllPathsForTree {

    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    static List<Integer> path = new ArrayList<Integer>();

    private static List<List<Integer>> getAllPaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(path));
        }
        getAllPaths(root.left);
        getAllPaths(root.right);
        path.remove(path.size() - 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.INST.generateTestTree(2);
        TreeNode.INST.levelOrderPrint(root);
        getAllPaths(root);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
