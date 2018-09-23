class BasicQueueUsingArray {
	private int size, head, tail;
	private int[] a;
	private int capacity;

	public BasicQueueUsingArray(int capacity) {
		this.capacity = capacity;
		this.head = -1;
		this.tail = -1;
		this.size = 0;
		this.a = new int[capacity];
	}

	public BasicQueueUsingArray() {
		this(5);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return head == capacity - 1;
	}

	public void push(int data) {
		if(isFull())
			return;

		size ++;
		head ++;
		a[head] = data;

	}

	public int pop() {
		if(isEmpty())
			return -999;

		size --;
		tail ++;
		return a[tail];
	}

	public int peek() {
		if(isEmpty())
			return -999;

		return a[head];
	}



}

