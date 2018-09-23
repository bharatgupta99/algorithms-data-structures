class QueueUsingLinkedList {

	private class Node {
		private int data;
		private Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	public Node tail = null;
	public Node head = null;

	public boolean isEmpty() {
		return tail == null;
	}

	public void push(int data) {
		Node temp = new Node(data);
		if(tail == null || head == null) {
			tail = temp;
			head = temp;
		}else{
			head.next = temp;
			head = temp;
		}
	}

	public int pop() {
		if(isEmpty())
			return -999;

		int d = tail.data;
		tail = tail.next;
		return d;
	}


	public int peek() {
		if(isEmpty())
			return -999;

		return head.data;
	}




}