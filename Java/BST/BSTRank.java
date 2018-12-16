class BSTRank {

	class Node {
		Node left;
		Node right;
		int data;
		int N; //no of node below me + myself
		public Node(int d) {
			this.left = null;
			this.right = null;
			this.data = d;
			this.N = 1;
		}
	}

	private Node root;

	public BSTRank() {
		root = null;
	}

	public void add(int d) {
		root = addUtil(d, root);
	}

	private Node addUtil(int d, Node node) {
		if(node == null) {
			return new Node(d);
		}else if(d > node.data) {
			node.right = addUtil(d, node.right);
		}else {
			node.left = addUtil(d, node.left);
		}
		node.N = node.N + 1;
		return node;
	}

	public int getRank(int d) {
		return getRankUtil(d, root);
	}

	private int getRankUtil(int d, Node node) {
		if(node == null) {
			return -1;
		}
		if(d == node.data) {
			return node.left == null ? 0 : node.left.N;
		}else if(d < node.data) {
			return getRankUtil(d, node.left);
		}else {
			return 1 + node.left.N + getRankUtil(d, node.right);
		}
	}



}