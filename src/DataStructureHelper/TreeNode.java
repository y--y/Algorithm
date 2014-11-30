package DataStructureHelper;

import java.util.*;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x){
		val = x;
	}
	public TreeNode() {
		this(Integer.MIN_VALUE);
	}

	public static TreeNode INST = new TreeNode();
	
	
	static String testTree1 = "{1, 2, 3, 4, #, 5, 6, #, #, 7, #, #, #, #, #}";
	static String testTree2 = "{1, #, 2, 3}";
	static String testTree3 = "{5, 4, 8, 11, #, 13, 4, 7, 2, #, #, 5, 1}";
	static String[] testTrees = {testTree1, testTree2, testTree3};

	public TreeNode generateTreeFromString(String str) {
		str = str.replaceAll("\\s+","");
		int start = str.indexOf("{") + 1;
		int end = str.indexOf("}");
		String strContent = str.substring(start , end);
		if (strContent.length() == 0) {
			return null;
		}
		String[] nodeValue = strContent.split(",");
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		for (int i = 0; i < nodeValue.length; i++) {
			if (nodeValue[i].equals("#")) {
				nodes.add(null);
			} else {
				int vodeValueInt = Integer.valueOf(nodeValue[i]);
				TreeNode node = new TreeNode(vodeValueInt);
				nodes.add(node);
			}
		}
		//		for (TreeNode node : nodes) {
		//			System.out.println(node == null ? null : node.val);
		//		}
		TreeNode root = nodes.get(0);
		TreeNode p;
		int leftIndex = 1;
		int rightIndex = 2;
		for (int i = 0; i < nodes.size(); i++) {
			p = nodes.get(i);
			if (p == null) {
				continue;
			}
			if (leftIndex >= nodes.size()) {
				p.left = null;
			} else {
				p.left = nodes.get(leftIndex);
				leftIndex += 2;
			}
			if (rightIndex >= nodes.size()) {
				p.right = null;
			} else {
				p.right = nodes.get(rightIndex);
				rightIndex += 2;
			}
		}
		return root;
	}

	public void levelOrderPrint(TreeNode root) {
		if (root == null) {
			System.out.println("Empty Tree");
		}
		List<List<String>> result = new ArrayList<List<String>>();
		List<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		boolean allEmpty = false;
		while (!queue.isEmpty() && !allEmpty) {
			List<TreeNode> queueCopy = new ArrayList<TreeNode>(queue);
			queue.clear();
			List<String> row = new ArrayList<String>();
			allEmpty = true;
			for (TreeNode node : queueCopy) {
				if (node.val == Integer.MIN_VALUE) {
					row.add("#");
				} else {
					row.add(String.valueOf(node.val));
				}
				if (node.left != null) {
					queue.add(node.left);
					allEmpty = false;
				} else {
					queue.add(new TreeNode());
				}
				if (node.right != null) {
					queue.add(node.right);
					allEmpty = false;
				} else {
					queue.add(new TreeNode());
				}
			}
			result.add(row);
		}

		//print
		for (List<String> row : result) {
			for (String node : row) {
				System.out.printf("%s ", node);
			}
			System.out.println();
		}
		System.out.println("******************************************");
	}

	public TreeNode generateTestTree(int num) {
		String str = testTrees[num];
		return generateTreeFromString(str);
	}
}
