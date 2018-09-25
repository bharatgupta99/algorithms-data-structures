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

	public void enqueue(int data) {
		if(isFull())
			return;

		size ++;
		tail = (tail + 1) % capacity;
		a[tail] = data;

	}

	public int dequeue() {
		if(isEmpty())
			return -999;

		size --;
		head = (head + 1) % capacity;
		return a[head];
	}

	public int peek() {
		if(isEmpty())
			return -999;

		return a[tail];
	}



}

