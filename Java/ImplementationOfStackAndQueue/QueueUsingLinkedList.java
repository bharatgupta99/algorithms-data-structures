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
		return head == null;
	}

	public void enqueue(int data) {
		Node temp = new Node(data);
		if(head == null || tail == null) {
			head = temp;
			tail = temp;
		}else{
			tail.next = temp;
			tail = temp;
		}
	}

	public int dequeue() {
		if(isEmpty())
			return -999;

		int d = head.data;
		head = head.next;
		return d;
	}


	public int peek() {
		if(isEmpty())
			return -999;

		return tail.data;
	}




}