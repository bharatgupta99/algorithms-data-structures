import java.util.Iterator;

public class Bag implements Iterable<Integer>{
	
	private Node first;
	private Node last;
	
	private class Node  {
		int data;
		Node next;
		private Node(int val) {
			this.data = val;
			this.next = null;
		}
	}
	
	public void enqueue(int val) {
		Node nn = new Node(val);
		if(first == null) {
			first = nn;
			last = nn;
		}else {
			last.next = nn;
			last = last.next;
		}
	}
	

	@Override
	public Iterator<Integer> iterator() {
		
		
		return new Iterator<Integer>() {

			private Node temp = first;
			@Override
			public boolean hasNext() {
				if(temp == null) {
					return false;
				}
				return true;
			}

			@Override
			public Integer next() {
				int val = temp.data;
				temp = temp.next;
				return val;
			}
		};
	}
	
	
	

	
	
}
