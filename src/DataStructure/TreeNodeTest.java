package DataStructure;

import DataStructureHelper.TreeNode;

public class TreeNodeTest {

    public static void main(String[] args) {
        TreeNode root = TreeNode.INST.generateTestTree(0);
        TreeNode.INST.levelOrderPrint(root);
    }
}
