import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node last;
	private Node first; 
	private int sz;

	private class Node {
		Item data;
		Node next;
		Node prev;

		private Node(Item data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}


	public Deque() {
		first = null;
		last = null;
		sz = 0;
	}

	public boolean isEmpty() {
		return sz == 0;
	}

	public int size() {
		return sz;
	}

	public void addFirst(Item data) {
		if (data == null) {
			throw new IllegalArgumentException("Null values cannot be added");
		}
		sz++;
		Node prevFirst = first;
		first = new Node(data);
		first.next = null;
		first.prev = prevFirst;

		if (last == null) {
			last = first;
		} else {
			prevFirst.next = first;
		} 
	}

	public void addLast(Item data) {
		if (data == null) {
			throw new IllegalArgumentException("Null values cannot be added");
		}
		sz++;
		Node nn = new Node(data);
		nn.next = last;
		nn.prev = null;
		if (first == null) {
			first = nn;
		}else {
			last.prev = nn;
		}
		last = nn;
	}

	public Item removeFirst() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		sz--;
		Node temp = first;
		first = first.prev;
		if(sz == 0) {
			last = null;
		}
		if(first != null) {
			first.next = null;
		}
		return temp.data;
	}

	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		sz--;
		Node temp = last;
		last = last.next;
		if(sz == 0) {
			first = null;
		}
		if(last != null) {
			last.prev = null;
		}
		return temp.data;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node temp = first;

			@Override
			public boolean hasNext() {
				return temp != null;
			}

			@Override
			public Item next() {
				if (!hasNext()) {
					throw new NoSuchElementException("Iteration over");
				}
				Item d = temp.data;
				temp = temp.prev;
				return d;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException("Cant perform this operation");
			}
		};
	}
}