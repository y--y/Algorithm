package DataStructure;

import DataStructureHelper.TreeNode;

public class TreeNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		String test = TreeNode.INST.generateStringFromTree(root);
		System.out.println(test);
	}
}
