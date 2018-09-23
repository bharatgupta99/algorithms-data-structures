class CircularQueueUsingArray {
	private int size, head, tail;
	private int[] a;
	private int capacity;

	public CircularQueueUsingArray(int capacity) {
		this.capacity = capacity;
		this.head = -1;
		this.tail = -1;
		this.size = 0;
		this.a = new int[capacity];
	}

	public CircularQueueUsingArray() {
		this(5);
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == capacity - 1;
	}

	public void push(int data) {
		if(isFull())
			return;

		size ++;
		head = (head + 1) % capacity;
		a[head] = data;

	}

	public int pop() {
		if(isEmpty())
			return -999;

		size --;
		tail = (tail + 1) % capacity;
		return a[tail];
	}

	public int peek() {
		if(isEmpty())
			return -999;

		return a[head];
	}



}

