package DataStructure;

import DataStructureHelper.TreeNode;

public class TreeNodeTest {
	
	final static String testTree1 = "{1, 2, 3, 4, #, 5, 6, #, #, 7, #, #, #, #, #}";
	final static String testTree2 = "{1, #, 2, 3}";
	final static String testTree3 = "{5, 4, 8, 11, #, 13, 4, 7, 2, #, #, 5, 1}";

	public static void main(String[] args) {
		TreeNode root = TreeNode.INST.generateTreeFromString(testTree3);
		TreeNode.INST.levelOrderPrint(root);
	}
}
