/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCode;

import java.util.*;

public class WordLadder2 {

	public static class Node {
		String label;
		Set<Node> neighbors;
		Node(String str) {
			label = str;
			neighbors = new HashSet<Node>();
		}
	}

	public static Node buildGraph(String start, String end, Set<String> dict) {
		dict.add(end);
		dict.remove(start);
		List<String> queue = new ArrayList<String>();
		queue.add(start);
		Map<String, Node> map = new HashMap<String, Node>();
		map.put(start, new Node(start));

		while (!queue.isEmpty()) {
			List<String> queueCopy = new ArrayList<String>(queue);
			queue.clear();
			List<String> removeList = new ArrayList<String>();
			for (String curStr : queueCopy) {
				for (int i = 0; i < curStr.length(); i++) {
					char[] curChar = curStr.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						curChar[i] = c;
						String newStr = new String(curChar);
						if (dict.contains(newStr)) {
							Node newNode;
							if (map.containsKey(newStr)) {
								newNode = map.get(newStr);
							} else {
								newNode = new Node(newStr);
								map.put(newStr, newNode);
							}
							newNode.neighbors.add(map.get(curStr));
							queue.add(newStr);
							removeList.add(newStr);
						}
					}
				}
			}
			for (String str : removeList) {
				dict.remove(str);
			}
		}
		return map.get(end);
	}
	static List<List<String>> result = new ArrayList<List<String>>();
	static List<String> path = new ArrayList<String>();

	private static List<List<String>> DFS(Node root, String start) {
		if (root == null) {
			return result;
		}
		path.add(root.label);
		if (root.label.equals(start)) {
			List<String> realPath = new ArrayList<String>();
			for (int i = 0; i < path.size(); i++) {
				realPath.add(path.get(path.size() - i - 1));
			}
			result.add(realPath);
		}
		for (Node node : root.neighbors) {
			DFS(node, start);
		}
		path.remove(path.size() - 1);
		return result;
	}

	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		Node root = buildGraph(start, end, dict);
		levelOrderTest(root);
		return DFS(root, start);
	}

	public static void main(String[] args) {
		String start = "nape";
		String end = "mild";
		Set<String> dict = new HashSet<String>(Arrays.asList("dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"));

		//        String start = "hit";
		//        String end = "cog";
		//        Set<String> dict = new HashSet<String>(Arrays.asList("hxt", "hot", "dot", "dog", "lot", "log"));
		findLadders(start, end, dict);
		for (List<String> row : result) {
			System.out.println(row);
		}
	}

	private static void levelOrderTest(Node root) {
		List<Node> queue = new ArrayList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Node> queueCopy = new ArrayList<Node>(queue);
			queue.clear();
			for (Node node : queueCopy) {
				System.out.printf("%s  ", node.label);
				for (Node neighbor : node.neighbors) {
					if (!queue.contains(neighbor)) {
						queue.add(neighbor);
					}
				}
			}
			System.out.println();
		}
	}
}
