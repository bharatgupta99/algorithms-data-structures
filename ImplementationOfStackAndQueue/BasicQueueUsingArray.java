class BasicQueueUsingArray {
	public int size, head, tail;
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
		return tail == capacity - 1;
	}

	public void enqueue(int data) {
		if(isFull())
			return;

		size ++;
		tail ++;
		a[tail] = data;

	}

	public int dequeue() {
		if(isEmpty())
			return -999;

		size --;
		head ++;
		return a[head];
	}

	public int peek() {
		if(isEmpty())
			return -999;

		return a[tail];
	}



}

