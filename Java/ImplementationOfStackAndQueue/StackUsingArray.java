class StackUsingArray {

	private int top;
	private int capacity;
	private int[] a;

	public StackUsingArray(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		a = new int[this.capacity];
	}

	public StackUsingArray() {
		this(5);
	}

	public boolean isFull() {
		return top == capacity - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int d) {
		if(isFull())
			throw new IllegalArgumentException("Stack Overflow");
		a[++top] = d;
	}

	public int pop() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Stack Underflow");
		int temp = a[top];
		--top;
		return temp;
	}

	public int peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Stack is Empty");
		return a[top];
	}

}