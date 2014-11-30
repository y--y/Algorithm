package DataStructureHelper;

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
	
	//TODO1
	public TreeNode generateTreeFromString(String str) {
		return null;
	}
	
	//TODO
	public String generateStringFromTree(TreeNode root) {
		return "not support yet";
	}
	
	//TODO
	public void levelOrder(TreeNode root) {
		
	}
}
