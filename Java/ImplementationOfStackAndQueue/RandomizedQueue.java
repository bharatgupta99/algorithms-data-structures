import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
	
	private Item[] q;
	private int sz;

	public RandomizedQueue() {
		this.q = (Item[]) new Object[4];
		this.sz = 0;
	}

	public boolean isEmpty() {
		return sz == 0;
	}

	public int size() {
		return sz;
	}

	public void enqueue(Item data) {
		if (data == null) {
			throw new IllegalArgumentException("Data can't be null");
		}
		if (sz >= q.length) {
			resize();
		}
		int r = StdRandom.uniform(q.length);
		while (q[r] != null) {
			r = StdRandom.uniform(q.length);
		}
		q[r] = data;
		sz++;
	}

	public Item dequeue() {
		if (sz == 0) {
			throw new NoSuchElementException("Queue is already empty");
		}
		int r = StdRandom.uniform(q.length);
		while (q[r] == null) {
			r = StdRandom.uniform(q.length);
		}
		Item val = q[r];
		q[r] = null;
		sz--;
		return val;
	}

	public Item sample() {
		if (sz == 0) {
			throw new NoSuchElementException("Queue is empty");
		}
		int r = StdRandom.uniform(q.length);
		while (q[r] == null) {
			r = StdRandom.uniform(q.length);
		}
		return q[r];
	}

	private void resize() {
		Item[] n = (Item[]) new Object[q.length * 2];
		for (int i = 0; i < sz; i++) {
			n[i] = q[i];
		}
		q = n;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			Item[] temp = q;
			int tempSize = sz;
			@Override
			public boolean hasNext() {
				return tempSize != 0;
			}
			@Override
			public Item next() {
				if (tempSize == 0) {
					throw new NoSuchElementException("No more element found!");
				}
				tempSize--;
				int r = StdRandom.uniform(q.length);
				while (temp[r] == null) {
					r = StdRandom.uniform(q.length);
				}
				Item val = temp[r];
				temp[r] = null;
				return val;
			}
			@Override
			public void remove() {
				throw new UnsupportedOperationException("Can't perform the operation");
			}
		};
	}
}