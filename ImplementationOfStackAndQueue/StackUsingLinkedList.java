class StackUsingLinkedList {

	private class Node {
		private int data;
		private Node next;

		public Node(int d) {
			this.data = d;
			this.next = null;
		}
	}

	private Node root = null;

	public boolean isEmpty() {
		return root == null;
	}

	public void push(int data) {
		Node temp = new Node(data);
		temp.next = root;
		root = temp;
	}

	public int pop() {
		if(isEmpty())
			return -999;

		Node temp = root;
		int d = temp.data;
		root = root.next;
		return d;
	}

	public int peek() {
		if(isEmpty())
			return -999;

		return root.data;
	}



}